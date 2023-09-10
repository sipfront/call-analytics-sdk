import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING
import org.jetbrains.dokka.DokkaConfiguration
import org.jetbrains.dokka.base.DokkaBase
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.dokka.base.DokkaBaseConfiguration
import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode
import org.jetbrains.kotlin.gradle.plugin.mpp.BitcodeEmbeddingMode
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework
import java.io.FileInputStream
import java.net.URL
import java.util.*

buildscript {
    dependencies {
        classpath(libs.buildscriptdep.dokka.base)
    }
}

plugins {
    alias(libs.plugins.dokka).apply(true)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.cocoapods)
    alias(libs.plugins.android.library)
    alias(libs.plugins.buildkonfig)
    id("maven.publish.script")
}

val javaVersion: JavaVersion = JavaVersion.VERSION_17
val javaLanguageVersion: JavaLanguageVersion = JavaLanguageVersion.of(javaVersion.majorVersion)
// true for any publish to local Maven, including subtasks like publishAndroidDebugPublicationToMavenLocal
val isPublishToMavenLocal =
    gradle.startParameter.taskNames.any { taskName -> "^publish.*ToMavenLocal$".toRegex().matches(taskName) }
val localProperties = Properties().apply {
    val localPropertiesFile = rootProject.file("local.properties")
    if (localPropertiesFile.exists()) {
        load(FileInputStream(localPropertiesFile))
    }
}
val projectProperties = Properties().apply {
    val localPropertiesFile = rootProject.file("project.properties")
    if (localPropertiesFile.exists()) {
        load(FileInputStream(localPropertiesFile))
    }
}
val packageName: String = projectProperties.getProperty("package.name")

group = packageName
/**
 * Here we suffix "-local" to the library version if the build is published to local maven, which is used
 * in testing during development of new library versions. With this suffix we can in the app that consumes
 * our library control if the mavenCentral or mavenLocal version of the library is loaded
 */
version = if (isPublishToMavenLocal) "${libs.versions.version.get()}-local" else libs.versions.version.get()

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class) kotlin {
    explicitApi = ExplicitApiMode.Disabled

    targetHierarchy.custom {
        common {
            group("androidAndJvm") {
                withJvm()
                withAndroidTarget()
            }
            group("apple") {
                group("ios") { withIos() }
                group("macos") { withMacos() }
            }
            withJs()
        }
    }

    jvm()
    androidTarget {
        publishLibraryVariants("release", "debug")
    }

    val xcFramework = XCFramework()
    listOf(
        iosX64(), iosArm64(), iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "${projectProperties.getProperty("project.name")}Binary"
            xcFramework.add(this)
        }
    }
    macosArm64()
    macosX64()
    js {
        browser {}
        nodejs {}
        binaries.executable()
    }

    sourceSets {
        all {
            languageSettings.optIn("kotlin.RequiresOptIn")
        }
        val commonMain by getting {
            dependencies {
                // kotlinx
                implementation(libs.bundles.kotlinx.common)
                // network
                implementation(libs.bundles.ktor.common)
                // other
                implementation(libs.bundles.stately)
                implementation(libs.atomicfu)
                implementation(libs.kermit)
            }
        }
        val androidAndJvmMain by getting {
            dependsOn(commonMain)
            dependencies {
                // network
                implementation(libs.ktor.client.okHttp)
                implementation(libs.minidns.hla)
            }
        }
        val jvmMain by getting {
            dependsOn(androidAndJvmMain)
        }
        val androidMain by getting {
            dependsOn(androidAndJvmMain)
            dependencies {
                // android
                implementation(libs.androidx.core)
                implementation(libs.kotlinx.coroutines.android)
            }
        }
        val iosMain by getting
        val macosMain by getting
        val appleMain by getting {
            dependsOn(commonMain)
            iosMain.dependsOn(this)
            macosMain.dependsOn(this)
            dependencies {
                // network
                implementation(libs.ktor.client.apple)
                // other
                api(libs.kermit.simple)
            }
        }
        val jsMain by getting {
            dependsOn(commonMain)
            dependencies {
                // network
                implementation(libs.ktor.client.js)
            }
        }
    }

    cocoapods {
        name = projectProperties.getProperty("package.cocoapod.name")
        version = libs.versions.version.get()
        summary = projectProperties.getProperty("project.description")
        homepage = projectProperties.getProperty("project.homepage")
        source = "{ :git => '${projectProperties.getProperty("repository.https")}', :tag => '$version' }"
        license = "{ :type => '${projectProperties.getProperty("project.license.type")}', :file => 'LICENSE' }"
        authors =
            "{ '${projectProperties.getProperty("author.fullname")}' => '${projectProperties.getProperty("author.email")}' }"
        ios.deploymentTarget = libs.versions.deployment.target.get()

        framework {
            baseName = projectProperties.getProperty("package.cocoapod.name")
            isStatic = false
            transitiveExport = false
            // not supported anymore since iOS 14, see:
            // https://developer.apple.com/documentation/xcode-release-notes/xcode-14-release-notes#Deprecations
            embedBitcode(BitcodeEmbeddingMode.DISABLE)
        }
    }
}

android {
    @Suppress("UnstableApiUsage")
    buildToolsVersion = libs.versions.buildTools.get()

    namespace = packageName
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }

    @Suppress("UnstableApiUsage") sourceSets {
        getByName("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            java.srcDirs("src/androidMain/kotlin")
            res.srcDirs("src/androidMain/kotlin")
        }
    }

    @Suppress("UnstableApiUsage") buildFeatures {
        buildConfig = true
    }

    buildTypes {
        // No obfuscation, debug logs enabled
        debug {
            isMinifyEnabled = false
        }
        // Obfuscated, debug logs disabled
        release {
            initWith(getByName("debug"))
            isMinifyEnabled = true
            @Suppress("UnstableApiUsage") proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "../proguard/proguard-rules-release.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }
    java {
        toolchain.languageVersion.set(javaLanguageVersion)
    }
    packaging {
        resources.excludes += "META-INF/INDEX.LIST"
        resources.excludes += "META-INF/io.netty.versions.properties"
    }
}

buildkonfig {
    packageName = this@Build_gradle.packageName
    /**
     * We add the Sipfront API credentials to the BuildKonfig only if this build is published to local Maven, that is
     * used only for development purposes
     */
    val sipfrontApiUser = if (isPublishToMavenLocal) localProperties.getProperty("sipfront.api.username") else ""
    val sipfrontApiPass = if (isPublishToMavenLocal) localProperties.getProperty("sipfront.api.password") else ""
    val sipfrontApiServer = if (isPublishToMavenLocal) localProperties.getProperty("sipfront.api.server") else ""

    defaultConfigs {
        buildConfigField(STRING, "VERSION_CODE", libs.versions.version.get())
        buildConfigField(STRING, "COMPANY_NAME", projectProperties.getProperty("company.name"))
        buildConfigField(STRING, "PROJECT_NAME", projectProperties.getProperty("project.name"))
        buildConfigField(STRING, "NAMESPACE", packageName)
        buildConfigField(STRING, "SIPFRONT_API_DEBUG_USER", sipfrontApiUser)
        buildConfigField(STRING, "SIPFRONT_API_DEBUG_PASS", sipfrontApiPass)
        buildConfigField(STRING, "SIPFRONT_API_DEBUG_SERVER", sipfrontApiServer)
    }
}

val copyReleaseXCFramework by tasks.registering(Copy::class) {
    val releaseDir = mkdir("${project.rootDir}/")
    from("${project.projectDir}/build/cocoapods/publish/release")
    into(releaseDir)
}

tasks.named("podPublishReleaseXCFramework").configure {
    finalizedBy(copyReleaseXCFramework)
}

// Dokka task generating documentation
tasks.withType<DokkaTask>().configureEach {
    moduleName.set(projectProperties.getProperty("project.name"))
    moduleVersion.set(libs.versions.version.get())
    suppressObviousFunctions.set(true)

    pluginConfiguration<DokkaBase, DokkaBaseConfiguration> {
        footerMessage = "Ⓒ 2023 Sipfront GmbH"
        separateInheritedMembers = true
    }

    dokkaSourceSets.configureEach {
        documentedVisibilities.set(setOf(DokkaConfiguration.Visibility.PUBLIC))
        suppressGeneratedFiles.set(true)
        includeNonPublic.set(false)
        skipDeprecated.set(true)
        reportUndocumented.set(true)
        skipEmptyPackages.set(true)
        includes.from("../MODULE.md")

        perPackageOption {
            matchingRegex.set("""^com\.sipfront\.sdk\.(pjsip|interfaces|json\.message\.base).*""")
            suppress.set(true)
        }

        sourceLink {
            localDirectory.set(file("${rootProject.projectDir}/call-analytics/src"))
            remoteUrl.set(URL("https://github.com/sipfront/call-analytics-sdk/tree/master/call-analytics/src"))
            remoteLineSuffix.set("#L")
        }
    }
}