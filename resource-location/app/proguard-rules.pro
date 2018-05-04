# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /opt/android/android-sdk-macosx/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

#-assumenosideeffects class android.util.Log { *; }
-assumenosideeffects public class android.util.Log {
    public static *** v(...);
    public static *** d(...);
    public static *** i(...);
    public static *** w(...);
    public static *** e(...);
    public static *** wtf(...);
}
-keepattributes *Annotation*,Exception,Signature,InnerClass

-keep class net.arnx.jsonic.** { *; }
-dontwarn net.arnx.jsonic.**
#-dontnote net.arnx.jsonic.**

-keep class android.support.v4.** { *; }
-dontwarn android.support.v4.**

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
   public *;
}

