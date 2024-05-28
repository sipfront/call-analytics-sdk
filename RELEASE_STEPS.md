# Release Steps Documentation

### Github

* Bump version property in gradle/libs.version.toml file
* Run Gradle task root/Tasks/buildkonfig/generateBuildKonfig
* Run Gradle task root/Tasks/cocoapods/podPublishReleaseXCFramework
* Run Gradle task root/call-analytics/Tasks/cocoapods/podPublishReleasePodspec
* Commit changed files (gradle/libs.version.toml, CallAnalyticsSdk.xcframework, CallAnalyticsSdk.podspec and call-analytics/CallAnalyticsSdk.podspec)
* Create a new Git Tag in format *.*.* on HEAD (last commit)
* Push commit and tag to Github

After this a Github release workflow should start that generates API documentation and a new Commit that contains a ZIP file with the iOS library, the project source code and the license.

### Maven Central

* Make sure secring.gpg and correctly configured local.properties is present in project root
* Run Gradle task root/Tasks/publishing/publishAllPublicationsToSonatypeRepository
* Login to Nexus Repository Manager at https://s01.oss.sonatype.org/#stagingRepositories
* Close new repository entry
* Once the release has been closed, release it with the option to automatically drop enabled
* The repository entry will be gone and after approximately 24 hours the library will be available on Maven Central

### CocoaPods

* Open terminal and navigate to project root
* Run Validation: ```pod spec lint CallAnalyticsSdk.podspec```
* Push to CocoaPods ```pod trunk push CallAnalyticsSdk.podspec```
* You should get a confirmation email that a new version of CallAnalyticsSdk has been released

### Build locally

* Javascript Web Apps: Run Gradle task root/Tasks/build/jsBrowserProductionWebPack or jsBrowserDevelopmentWebPack
* Maven Local: Run Gradle task root/Tasks/publishing/publishToMavenLocal