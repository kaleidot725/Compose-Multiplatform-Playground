# License Screen Demo


## About

- This demo is creating a license file using licensee.
- This demo defines a gradle task called `updateLicense`, `updateLicense` generate and install `artifact.json` file.
- This app displays the license list using the `artifact.json` file.

## Build

### Before running!
- check your system with [KDoctor](https://github.com/Kotlin/kdoctor)
- install JDK 8 on your machine
- add `local.properties` file to the project root and set a path to Android SDK there

### Android
To run the application on android device/emulator:
- open project in Android Studio and run imported android run configuration

To build the application bundle:
- run `./gradlew :composeApp:assembleDebug`
- find `.apk` file in `composeApp/build/outputs/apk/debug/composeApp-debug.apk`

### Desktop
Run the desktop application: `./gradlew :composeApp:run`

### iOS
To run the application on iPhone device/simulator:
- Open `iosApp/iosApp.xcproject` in Xcode and run standard configuration
- Or use [Kotlin Multiplatform Mobile plugin](https://plugins.jetbrains.com/plugin/14936-kotlin-multiplatform-mobile) for Android Studio

### Update `artifact.json`

- Run `./gradlew updateLicense`, so generate and install the `artifact.json` file.