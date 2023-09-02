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
    val projectPropertiesFile = file("project.properties")
    if (projectPropertiesFile.exists()) {
        load(FileInputStream(projectPropertiesFile))
    }
}

rootProject.name = projectProperties.getProperty("project.id")
include(":call-analytics")
includeBuild("maven-publish-script")
