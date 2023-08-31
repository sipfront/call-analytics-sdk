import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.`maven-publish`
import org.gradle.kotlin.dsl.signing
import java.io.FileInputStream
import java.util.*

/**
 * In order to sign a publication you will need to add the Sonatype credentials and signing keys in the local.properties
 * file, using the following format:
 *
 * # The GPG key pair ID (last 8 digits of its fingerprint)
 * signing.keyId=<key>
 * # The passphrase of the key pair
 * signing.password=<pass>
 * # Private key you exported earlier
 * signing.secretKeyRingFile=<path/to/secring.gpg>
 * # Your credentials for the Sonatype account
 * ossrhUsername=<user>
 * ossrhPassword=<pass>
 */

plugins {
    `maven-publish`
    signing
}

// Stub secrets to let the project sync and build without the publication values set up
ext["signing.keyId"] = null
ext["signing.password"] = null
ext["signing.secretKeyRingFile"] = null
ext["ossrhUsername"] = null
ext["ossrhPassword"] = null

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
    ext["ossrhUsername"] = System.getenv("OSSRH_USERNAME")
    ext["ossrhPassword"] = System.getenv("OSSRH_PASSWORD")
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
                username = getExtraString("ossrhUsername")
                password = getExtraString("ossrhPassword")
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
            name.set(projectProperties.getProperty("name"))
            description.set(projectProperties.getProperty("description"))
            url.set(projectProperties.getProperty("homepage"))

            licenses {
                license {
                    name.set(projectProperties.getProperty("license"))
                    url.set(projectProperties.getProperty("license-url"))
                }
            }
            developers {
                developer {
                    id.set(projectProperties.getProperty("author-id"))
                    name.set(projectProperties.getProperty("author-name"))
                    email.set(projectProperties.getProperty("author-email"))
                }
            }
            scm {
                url.set(projectProperties.getProperty("github-project-page"))
            }
        }
    }
}

// Signing artifacts. Signing.* extra properties values will be used
signing {
    sign(publishing.publications)
}