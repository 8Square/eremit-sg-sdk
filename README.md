# Eremit Singapore SDK
This is a Eremit Singapore SDK sample application with integration steps as well.

Requirements
============

* Minimum Android SDK Version 21
* Working front and back camera in device

Integration Steps
=================

1. Add it in your root build.gradle at the end of repositories
  ```gradle
  allprojects {
    repositories {
        maven {
            url "http://maven.eightsquare.co:8081/artifactory/libs-release-local"
            credentials {
                username = "" //todo: add username
                password = "" //todo: add password
            }
        }
    }
}
```
2. Add the dependency in your application module's build.gradle
```gradle
  dependencies {
   implementation 'com.eightsquarei.eremitsgsdk:remit:1.0.0.3'
  }
```


3. Extend `RemitApplication` in your application class. And include application class in manifest.
```kotlin
    class YourApplication : RemitApplication() {}
```


4. Start SDK by
```kotlin
    EremitSdk.Builder()
                   .apiKey("api_key_here")
                   .env(Env.SIT)
                   .build().start(this)
```
  **Parameters**
  * `apiKey` - Get valid license key from support team
  * `envType`
    1. `EnvType.SIT`
    2. `EnvType.UAT`
    3. `EnvType.PROD`


Notes
=======

1. Migrate to AndroidX, if current application is in support library.
   Use the link below to migrate.
     [https://developer.android.com/jetpack/androidx/migrate](https://developer.android.com/jetpack/androidx/migrate)

2. Add below inside in android block if Java 8 incompatible error or receive crash log `java.lang.BootstrapMethodError: Exception from call site #5 bootstrap method....`
or `Static interface methods are only supported starting with Android N (--min-api 24)`
```gradle
   compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
   }
```
3. If you receive `Manifest merger failed : Attribute application@.....` error during application build, add the code below in application block in `AndroidManifest.xml`.
```xml
 tools:replace="android:theme,android:allowBackup""
```

4. If you receive `Unable to resolve dependency for ':app@debugAndroidTest/compileClasspath': Could not find any version that matches com.facebook.android:facebook-android-sdk:[8,9).`, add below inside repositories
```gradle
    mavenCentral()
```


