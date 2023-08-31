# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.kts.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
-renamesourcefileattribute SourceFile

# Prevent Kotlin (singleton) object class signature from being converted
-keep class kotlin.Metadata { *; }
-keepattributes InnerClasses,Signature,RuntimeVisible*Annotations,EnclosingMethod

# Classes that should not be removed or renamed should are implementing this interface
-keep class * implements com.sipfront.sdk.interfaces.ProguardKeep { *; }
# Moshi Json Parser
-keep class **JsonAdapter { *; }

# Required because we use reflection to find the proper class names
#-keepnames class com.sipfront.sdk.pjsip.pjsua2.reflection.*

-dontwarn java.lang.invoke.StringConcatFactory