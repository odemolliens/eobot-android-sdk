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

** 1.0.3 **

- Fixed a bug on getCoinPrice service

** 1.0.2 **

- Implement manual & automatic withdraw

** 1.0.1 **

- Implement cache request system

** 1.0.0 **

- All services from Eobot API are implemented
- All basics unit test are implemented


Copyright
==========


  	Copyright 2015 Olivier Demolliens

	Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
	
	file except in compliance with the License. You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software distributed under
	
	the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF 
	
	ANY KIND, either express or implied. See the License for the specific language governing
	
	permissions and limitations under the License.
