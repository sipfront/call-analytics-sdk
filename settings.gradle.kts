import java.io.FileInputStream
import java.util.*

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

val projectProperties = Properties().apply {
    val localPropertiesFile = file("project.properties")
    if (localPropertiesFile.exists()) {
        load(FileInputStream(localPropertiesFile))
    }
}

rootProject.name = "call-analytics"
include(":call-analytics")
includeBuild("maven-publish-script")
