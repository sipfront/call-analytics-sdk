import groovy.json.JsonSlurper
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.`maven-publish`
import org.gradle.kotlin.dsl.signing
import java.io.FileInputStream
import java.net.HttpURLConnection
import java.net.URI
import java.net.URLEncoder
import java.util.*

/**
 * In order to sign a publication you will need to add the Sonatype credentials and signing keys in the local.properties
 * See local.properties.example file for expected format
 */

plugins {
    `maven-publish`
    signing
}

// Stub secrets to let the project sync and build without the publication values set up
ext["signing.keyId"] = null
ext["signing.password"] = null
ext["signing.secretKeyRingFile"] = null
ext["ossrh.username"] = null
ext["ossrh.password"] = null

// Grabbing secrets from local.properties file or from environment variables, which could be used on CI
val localProperties = project.rootProject.file("local.properties")
if (localProperties.exists()) {
    localProperties.reader().use {
        Properties().apply {
            load(it)
        }
    }.onEach { (name, value) ->
        ext[name.toString()] = value
    }
} else {
    ext["signing.keyId"] = System.getenv("SIGNING_KEY_ID")
    ext["signing.password"] = System.getenv("SIGNING_PASSWORD")
    ext["signing.secretKeyRingFile"] = System.getenv("SIGNING_SECRET_KEY_RING_FILE")
    ext["ossrh.username"] = System.getenv("OSSRH_USERNAME")
    ext["ossrh.password"] = System.getenv("OSSRH_PASSWORD")
}
val projectProperties = Properties().apply {
    val localPropertiesFile = rootProject.file("project.properties")
    if (localPropertiesFile.exists()) {
        load(FileInputStream(localPropertiesFile))
    }
}

fun getExtraString(name: String) = ext[name]?.toString()

val ossrhStagingApiNamespace = projectProperties.getProperty("package.name")
val ossrhStagingApiPublishTaskName = "publishAllPublicationsToOssrhStagingApiRepository"
val ossrhStagingApiBaseUrl = "https://ossrh-staging-api.central.sonatype.com"

data class OssrhStagingApiResponse(val responseCode: Int, val responseBody: String)
data class OssrhStagingApiRepository(val key: String, val state: String)

fun ossrhStagingApiRequest(method: String, endpoint: String, token: String): OssrhStagingApiResponse {
    val connection = URI(endpoint).toURL().openConnection() as HttpURLConnection

    try {
        connection.requestMethod = method
        connection.connectTimeout = 30_000
        connection.readTimeout = 120_000
        connection.setRequestProperty("Authorization", "Bearer $token")

        val responseCode = connection.responseCode
        val responseStream = if (responseCode in 200..299) connection.inputStream else connection.errorStream
        val responseBody = responseStream?.bufferedReader()?.use { it.readText() }.orEmpty()

        return OssrhStagingApiResponse(responseCode, responseBody)
    } finally {
        connection.disconnect()
    }
}

fun successfulOssrhStagingApiResponse(response: OssrhStagingApiResponse) = response.responseCode in 200..299

fun requireSuccessfulOssrhStagingApiResponse(action: String, response: OssrhStagingApiResponse) {
    if (!successfulOssrhStagingApiResponse(response)) {
        throw GradleException(
            "$action failed. HTTP ${response.responseCode}" +
                response.responseBody.takeIf { it.isNotBlank() }?.let { ": $it" }.orEmpty()
        )
    }
}

fun findOssrhStagingApiRepositories(namespace: String, token: String): List<OssrhStagingApiRepository> {
    val encodedNamespace = URLEncoder.encode(namespace, Charsets.UTF_8)
    val response = ossrhStagingApiRequest(
        "GET",
        "$ossrhStagingApiBaseUrl/manual/search/repositories?ip=any&profile_id=$encodedNamespace",
        token
    )
    requireSuccessfulOssrhStagingApiResponse("Searching OSSRH staging repositories", response)

    val parsed = JsonSlurper().parseText(response.responseBody) as? Map<*, *> ?: return emptyList()
    val repositories = parsed["repositories"] as? List<*> ?: return emptyList()

    return repositories.mapNotNull { repository ->
        val repositoryMap = repository as? Map<*, *> ?: return@mapNotNull null
        val key = repositoryMap["key"]?.toString()?.takeIf { it.isNotBlank() } ?: return@mapNotNull null
        val state = repositoryMap["state"]?.toString()?.takeIf { it.isNotBlank() } ?: return@mapNotNull null

        OssrhStagingApiRepository(key, state)
    }
}

fun selectOssrhStagingApiRepository(repositories: List<OssrhStagingApiRepository>): OssrhStagingApiRepository {
    val candidates = repositories.filter { it.state != "released" }
    val openRepositories = candidates.filter { it.state == "open" }

    return when {
        openRepositories.size == 1 -> openRepositories.single()
        candidates.size == 1 -> candidates.single()
        candidates.isEmpty() -> throw GradleException("No open OSSRH staging repositories found.")
        else -> {
            val candidateList = candidates.joinToString(separator = "\n") { " - ${it.key} (${it.state})" }
            throw GradleException(
                "Multiple OSSRH staging repositories found. Re-run with " +
                    "-PossrhStagingApiRepositoryKey=<key> using one of:\n$candidateList"
            )
        }
    }
}

fun uploadOssrhStagingRepositoryToCentralPortal(repositoryKey: String, token: String): OssrhStagingApiResponse =
    ossrhStagingApiRequest(
        "POST",
        "$ossrhStagingApiBaseUrl/manual/upload/repository/$repositoryKey?publishing_type=user_managed",
        token
    )

publishing {
    repositories {
        maven {
            name = "ossrhStagingApi"
            setUrl("https://ossrh-staging-api.central.sonatype.com/service/local/staging/deploy/maven2/")
            credentials {
                username = getExtraString("ossrh.username")
                password = getExtraString("ossrh.password")
            }
        }
    }

    // Configure all publications
    publications.withType<MavenPublication> {
        // provide a signed javadoc jar, following code takes care of Gradle dependency issue
        // https://github.com/gradle/gradle/issues/26091
        // https://youtrack.jetbrains.com/issue/KT-46466
        val publication = this
        val javadocJar = tasks.register("${publication.name}JavadocJar", Jar::class) {
            archiveClassifier.set("javadoc")
            // Each archive name should be distinct. Mirror the format for the sources Jar tasks.
            archiveBaseName.set("${archiveBaseName.get()}-${publication.name}")
        }
        artifact(javadocJar)

        // Provide artifacts information requited by Maven Central
        pom {
            name.set(projectProperties.getProperty("project.title"))
            description.set(projectProperties.getProperty("project.description"))
            url.set(projectProperties.getProperty("project.homepage"))

            licenses {
                license {
                    name.set(projectProperties.getProperty("project.license.type"))
                    url.set(projectProperties.getProperty("project.license.url"))
                }
            }
            developers {
                developer {
                    id.set(projectProperties.getProperty("author.id"))
                    name.set(projectProperties.getProperty("author.fullname"))
                    email.set(projectProperties.getProperty("author.email"))
                }
            }
            scm {
                url.set(projectProperties.getProperty("repository.webpage"))
            }
        }
    }
}

// Signing artifacts. Signing.* extra properties values will be used
signing {
    sign(publishing.publications)
}

val uploadOssrhStagingRepositoryToCentralPortal = tasks.register("uploadOssrhStagingRepositoryToCentralPortal") {
    group = "publishing"
    description = "Uploads the OSSRH staging API repository to the Central Portal for validation."

    doLast {
        val namespace = ossrhStagingApiNamespace
            ?: throw GradleException("Missing package.name in project.properties.")
        val username = getExtraString("ossrh.username")
        val password = getExtraString("ossrh.password")
        if (username.isNullOrBlank() || password.isNullOrBlank()) {
            throw GradleException(
                "Missing ossrh.username or ossrh.password. Configure local.properties or OSSRH_USERNAME/OSSRH_PASSWORD."
            )
        }

        val token = Base64.getEncoder().encodeToString("$username:$password".toByteArray(Charsets.UTF_8))
        val configuredRepositoryKey = findProperty("ossrhStagingApiRepositoryKey")?.toString()?.takeIf { it.isNotBlank() }
        if (configuredRepositoryKey != null) {
            val response = uploadOssrhStagingRepositoryToCentralPortal(configuredRepositoryKey, token)
            requireSuccessfulOssrhStagingApiResponse(
                "Uploading OSSRH staging repository $configuredRepositoryKey to Central Portal",
                response
            )
            logger.lifecycle(
                "Uploaded OSSRH staging repository $configuredRepositoryKey for namespace $namespace to Central Portal."
            )
            response.responseBody.takeIf { it.isNotBlank() }?.let { logger.lifecycle(it) }
        } else {
            val defaultRepositoryResponse = ossrhStagingApiRequest(
                "POST",
                "$ossrhStagingApiBaseUrl/manual/upload/defaultRepository/$namespace?publishing_type=user_managed",
                token
            )
            val response = if (successfulOssrhStagingApiResponse(defaultRepositoryResponse)) {
                defaultRepositoryResponse
            } else {
                logger.lifecycle(
                    "Default OSSRH staging repository lookup failed with HTTP " +
                        "${defaultRepositoryResponse.responseCode}; searching repositories with ip=any."
                )
                val repository = selectOssrhStagingApiRepository(findOssrhStagingApiRepositories(namespace, token))
                logger.lifecycle("Uploading OSSRH staging repository ${repository.key} (${repository.state}).")
                uploadOssrhStagingRepositoryToCentralPortal(repository.key, token)
            }

            requireSuccessfulOssrhStagingApiResponse("Uploading OSSRH staging repository to Central Portal", response)
            logger.lifecycle("Uploaded OSSRH staging repository for namespace $namespace to Central Portal.")
            response.responseBody.takeIf { it.isNotBlank() }?.let { logger.lifecycle(it) }
        }
    }
}

tasks.register("publishAllPublicationsToCentralPortal") {
    group = "publishing"
    description = "Publishes all publications to the OSSRH staging API and uploads them to the Central Portal."

    dependsOn(ossrhStagingApiPublishTaskName)
    dependsOn(uploadOssrhStagingRepositoryToCentralPortal)
}

uploadOssrhStagingRepositoryToCentralPortal.configure {
    mustRunAfter(ossrhStagingApiPublishTaskName)
}
