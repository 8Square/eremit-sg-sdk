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
        maven { url 'https://zendesk.jfrog.io/zendesk/repo' }
    }
}
```
2. Add the dependency in your application module's build.gradle
```gradle
  dependencies {
   implementation 'com.eightsquarei.eremitsgsdk:remit:1.0.0.24'
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
                   .env(Env.UAT)
                   .build().start(this)
```
  **Parameters**
  * `apiKey`
    - Get valid license key from support team. API key for UAT and PROD are different.
    - Mandatory parameter
  * `envType`
    1. `Env.UAT` - for integration and testing
    2. `Env.PROD` - for production, default value
  * `setUniqueIdentifier`
    - Send any string value
    - Optional parameter


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

Migration from 1.0.0.20 to 1.0.0.21
------------------------------------

1. Change import
  ```kotlin 
    import com.app.m1remit.EremitSdk
    import com.app.m1remit.model.enum_type.Env
  ```
  to
  ```kotlin
    import com.eightsquarei.sgsdk.EremitSdk
    import com.eightsquarei.sgsdk.model.enum_type.Env
  ```

2. Change import
  ```kotlin
  import com.app.m1remit.RemitApplication
  ```
  to 
  ```kotlin
  import com.eightsquarei.sgsdk.RemitApplication
  ```

