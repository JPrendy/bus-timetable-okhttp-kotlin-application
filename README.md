# template-repository

## Description

The existing repository is a template, I can generate new repositories with the same directory structure, branches, and files.

## Contents

- [Setup Steps](#setup-steps)
- [How to run the project locally](#how-to-run-the-project-locally)
- [Helpful resources](#helpful-resources)


## Setup Steps

Go to the app module build.gradle and add the following test dependency

```
implementation("com.squareup.okhttp3:okhttp:4.7.2")
implementation("com.google.code.gson:gson:2.8.6")
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

