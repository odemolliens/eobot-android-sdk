# eobot-android-sdk
[![JitPackGradle](https://img.shields.io/github/tag/odemolliens/eobot-android-sdk.svg?label=gradle)](https://jitpack.io/#odemolliens/eobot-android-sdk/)
[![JitPackMaven](https://img.shields.io/github/tag/odemolliens/eobot-android-sdk.svg?label=maven)](https://jitpack.io/#odemolliens/eobot-android-sdk/)


Gradle Setup
==========
```gradle

repositories {
    maven {
        url "https://jitpack.io"
    }
}

```
Compile in the build.gradle file. for X.X.X please refer to the change log.
```gradle
dependencies{
    compile 'com.github.odemolliens:eobot-android-sdk:x.x.x'
}
  ```
  
Maven Setup
==========

  Add Repository
```xml
<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>

```
  Add Dependency:
```xml
	<dependency>
	    <groupId>com.github.odemolliens</groupId>
	    <artifactId>eobot-android-sdk</artifactId>
	    <version>x.x.x</version>
	</dependency>

  ```

ChangeLog
===

** 1.0.2 **

- Implement manual & automatic withdraw

** 1.0.1 **

- Implement cache request system

** 1.0.0 **

- All services from Eobot API are implemented
- All basics unit test are implemented
