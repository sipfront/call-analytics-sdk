buildscript {
    dependencies {
        classpath(libs.buildscriptdep.kotlin.gradle.plugin)
        classpath(libs.buildscriptdep.android.gradle.plugin)
        classpath(libs.buildscriptdep.buildkonfig)
    }
}

// Top-level build file where you can add configuration options common to all subprojects/modules.
plugins {
    alias(libs.plugins.kotlin.multiplatform).apply(false)
    alias(libs.plugins.kotlin.serialization).apply(false)
    alias(libs.plugins.kotlin.cocoapods).apply(false)
    alias(libs.plugins.android.library).apply(false)
    alias(libs.plugins.buildkonfig).apply(false)
}