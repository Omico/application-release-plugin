# Application release plugin

When you change your build variant to `release`.

This is an easy way to apply Keystore in local properties.

## Usage

This project currently hasn't uploaded to JCenter or Maven Central.

You need to clone this project.

```shell
git clone https://github.com/Omico/application-release-plugin.git
```

Open this project with `Android Studio` or `IntelliJ IDEA` , then run `uploadArchives` task

### In your project

Add the plugin to your buildscript:

```gradle
buildscript {
    repositories {
        mavenLocal()
    }
    dependencies {
        classpath 'me.omico.gradle:application-release-plugin:1.0.0'
    }
}
```

Add `release.properties` in your working project root directory.

```txt
key.alias=omico
key.password=password
store.file=D:\\OmicoPrivateKey.jks
store.password=password
```

And then change `apply plugin: 'com.android.application'` to `apply plugin: 'me.omico.gradle.application'` in your application's `build.gradle`

Enjoy, have fun :) !

## License

```txt
Copyright 2019 Omico

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
