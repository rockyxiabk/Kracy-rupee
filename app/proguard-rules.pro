# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
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
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
# 代码混淆压缩比，在0~7之间，默认为5，一般不做修改
-optimizationpasses 5
-dontusemixedcaseclassnames# 混合时不使用大小写混合，混合后的类名为小写
-dontskipnonpubliclibraryclasses# 指定不去忽略非公共库的类
-dontskipnonpubliclibraryclassmembers
-dontpreverify# 不做预校验，preverify是proguard的四个步骤之一，Android不需要preverify，去掉这一步能够加快混淆速度。
-dontoptimize
-dontshrink#混淆jar的时候一定要配置，不然会把没有用到的代码全部remove
-verbose# 这句话能够使我们的项目混淆后产生映射文件 # 包含有类名->混淆后类名的映射关系
-keepattributes SourceFile,LineNumberTable# 抛出异常时保留代码行号
-optimizations !code/simplification/cast,!field/*,!class/merging/*

#kotlin
-keep class kotlin.** { *; }
-keep class kotlin.Metadata { *; }
-dontwarn kotlin.**
-keepclassmembers class **$WhenMappings {
    <fields>;
}
-keepclassmembers class kotlin.Metadata {
    public <methods>;
}
-assumenosideeffects class kotlin.jvm.internal.Intrinsics {
    static void checkParameterIsNotNull(java.lang.Object, java.lang.String);
}

-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}
-keepclassmembers class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}
-keep class **.R$* {*;}
-keepclassmembers enum * { *;}

#auto size
-keep class me.jessyan.autosize.** { *; }
-keep interface me.jessyan.autosize.** { *; }

#glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep class * extends com.bumptech.glide.module.AppGlideModule {
 <init>(...);
}
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
-keep class com.bumptech.glide.load.data.ParcelFileDescriptorRewinder$InternalRewinder {
  *** rewind();
}

# for DexGuard only
#-keepresourcexmlelements manifest/application/meta-data@value=GlideModule

# Gson 混淆
-keepattributes Signature
-keep class sun.misc.Unsafe { *; }
-keep class com.great.cash.rupee.entity.** { *; }

#okhttp3 混淆
-dontwarn okhttp3.**
-keep class okhttp3.** { *;}
-dontwarn okio.**
-keep class okio.** { *;}

# retrofit2 混淆
-keep public class retrofit2.** { *; }
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }

# rx.android 混淆
-keep public class io.reactivex.android.** { *; }
-dontwarn io.reactivex.android.**
-keep class io.reactivex.android.** { *; }

#Ucrop
-dontwarn com.yalantis.ucrop**
-keep class com.yalantis.ucrop** { *; }
-keep interface com.yalantis.ucrop** { *; }
-keep class com.great.cash.rupee.entity**{ *; }
-keep class com.great.cash.rupee.model**{ *; }
#Okio
-dontwarn org.codehaus.mojo.animal_sniffer.*

#webview-jar
-keep class com.just.agentweb.** {
    *;
}
-dontwarn com.just.agentweb.**
#Java 注入类不要混淆 ， 例如 sample 里面的 AndroidInterface 类 ， 需要 Keep 。
#-keepclassmembers class com.just.agentweb.sample.common.AndroidInterface{ *; }

 # 抓取数据 sdk
-keep class io.reactivex.** {*;}
-keep class com.yinlan.newdatasyc.bean.** { *; }
-keep class com.yinlan.newdatasyc.newwork.DataManagerSDK{
      public <methods>;#保持该类下所有的共有方法不被混淆
  }

  ## GSON 2.2.4 specific rules ##
  # Gson uses generic type information stored in a class file when working with fields. Proguard
  # removes such information by default, so configure it to keep all of it.
  -keepattributes EnclosingMethod
  # Gson specific classes
  -keep class sun.misc.Unsafe { *; }
  -keep class com.google.** { *; }


## GSON 2.2.4 specific rules ##
-keepattributes EnclosingMethod
-keep class sun.misc.Unsafe { *; }
-keep class com.google.** { *; }
 -dontwarn  co.hyperverge.**
 -keepclassmembers class * implements javax.net.ssl.SSLSocketFactory {
        private javax.net.ssl.SSLSocketFactory delegate;
   }


-keep class com.adjust.sdk.** { *; }
-keep class com.google.android.gms.common.ConnectionResult {
    int SUCCESS;
}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient {
    com.google.android.gms.ads.identifier.AdvertisingIdClient$Info getAdvertisingIdInfo(android.content.Context);
}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient$Info {
    java.lang.String getId();
    boolean isLimitAdTrackingEnabled();
}
-keep public class com.android.installreferrer.** { *; }

-dontwarn com.android.installreferrer

-keep class com.appsflyer.** { *; }

#OCR识别
-dontwarn com.dfsdk.**
-keep class com.dfsdk.** { *; }

#PictureSelector 2.0
-keep class com.luck.picture.lib.** { *; }

#Ucrop
-dontwarn com.yalantis.ucrop**
-keep class com.yalantis.ucrop** { *; }
-keep interface com.yalantis.ucrop** { *; }

-keep class com.just.agentweb.** {
    *;
}
-dontwarn com.just.agentweb.**
-keepclassmembers class com.just.agentweb.sample.common.AndroidInterface{ *; }

-keep class com.great.cash.rupee.risk.**{*; }