import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.`maven-publish`
import org.gradle.kotlin.dsl.signing
import java.io.FileInputStream
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

publishing {
    repositories {
        maven {
            name = "sonatype"
            setUrl("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
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