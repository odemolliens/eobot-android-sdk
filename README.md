# eobot-android-sdk
[![JitPackGradle](https://img.shields.io/github/tag/odemolliens/eobot-android-sdk.svg?label=gradle)](https://jitpack.io/#odemolliens/eobot-android-sdk/)
[![JitPackMaven](https://img.shields.io/github/tag/odemolliens/eobot-android-sdk.svg?label=maven)](https://jitpack.io/#odemolliens/eobot-android-sdk/)
[![Travis](https://travis-ci.org/odemolliens/eobot-android-sdk.svg)](https://travis-ci.org/odemolliens/eobot-android-sdk)
[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/odemolliens/eobot-android-sdk/trend.png)](https://bitdeli.com/free "Bitdeli Badge")



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

** 1.0.8 **

- Added X11 mining

** 1.0.7 **

- Some bugs fix

** 1.0.6 **

- Error management + some bugs fix

** 1.0.5 **

- Fix mininum deposit coins price

** 1.0.4 **

- Added getSupportedFiatCoins service

** 1.0.3 **

- Fixed a bug on getCoinPrice service

** 1.0.2 **

- Implement manual & automatic withdraw

** 1.0.1 **

- Implement cache request system

** 1.0.0 **

- All services from Eobot API are implemented
- All basics unit test are implemented

Donation
==========
[![Donation](https://blockchain.info/Resources/buttons/donate_64.png)](https://blockchain.info/address/1EobotDynsNEcx7X1TTkccq3RFqXoFPtP)


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
