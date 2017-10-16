# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\Android\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# nohttp
-dontwarn com.yolanda.nohttp.**
-keep class com.yolanda.nohttp.**{*;}

# nohttp-okhttp
-dontwarn com.yanzhenjie.nohttp.**
-keep class com.yanzhenjie.nohttp.**{*;}

# okhttp
-dontwarn okhttp3.**
-keep class okhttp3.** { *;}
-dontwarn okio.**
-keep class okio.** { *;}

-dontwarn java.lang.invoke.*
-dontwarn **$$Lambda$*


#如果提示ButterKnife 打包出错，可以取消第一行注释，如若还不行，打开全部注释试试
#-dontwarn butterknife.internal.**
#-keep class butterknife.** { *; }
#-dontwarn butterknife.internal.**
#-keep class **$$ViewBinder { *; }
#-keepclasseswithmembernames class * { @butterknife.* <fields>;}
#-keepclasseswithmembernames class * { @butterknife.* <methods>;}
