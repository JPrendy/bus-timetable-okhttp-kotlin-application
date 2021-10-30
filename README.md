# Bus timetable Okhttp Kotlin application

## Description

The following is a simple Kotlin application that uses Okhttp to fetch rest api data that is then shown on the activity screen of the application.

## Contents

- [Setup Steps](#setup-steps)
- [How to run the project locally](#how-to-run-the-project-locally)
- [Helpful resources](#helpful-resources)


## Setup Steps

Go to the app module build.gradle and add the following test dependency

```
implementation("com.squareup.okhttp3:okhttp:4.7.2")
implementation("com.google.code.gson:gson:2.8.6")
androidTestImplementation "com.squareup.okhttp3:mockwebserver:4.6.0"
androidTestImplementation 'androidx.test:rules:1.1.1'
androidTestImplementation 'androidx.test.ext:truth:1.1.0'
androidTestImplementation 'com.jakewharton.espresso:okhttp3-idling-resource:1.0.0'
```

Go to the `AndroidManifest.xml` and allow internet permission

```
<uses-permission android:name="android.permission.INTERNET"/>
```

## How to run the project locally

```
Code here
```

## Helpful resources

Issues related to the emulator not connecting to the internet.
- [link](https://stackoverflow.com/a/49332186).

Great video on how to fetch JSON with OkHttp and Gson with Kotlin.
- [link](https://www.youtube.com/watch?v=53BsyxwSBJk).

OkHttp official references for asynchronous get examples in Kotlin
- [link](https://square.github.io/okhttp/recipes/).


