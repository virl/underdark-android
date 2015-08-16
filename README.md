# Underdark for Android
Peer-to-peer networking library for Android, with Wi-Fi and Bluetooth support.
## Author
You can contact me at http://telegram.me/virlof

## Installation
First, add underdark repository in your root or app's build.gradle:
```
repositories {
    maven {
        url 'https://dl.bintray.com/glint/maven/'
    }
}
```
Next, add Underdark library dependency in your apps' build.gradle:
```
dependencies {
    compile 'io.underdark:underdark:1.+'
}
```
## Getting started
Underdark API is very simple — it consists of entry class `Underdark` with method `configureTransport()` — it allows you to create `Transport` instance with desired parameters (like network interface type) and set listener for callbacks.

Full documentation resides in javadoc jar, starting from `io.underdark.Underdark` class.
If you're using Android Studio or IntelliJ IDEA, you can automatically download it like that:
```
apply plugin: 'idea'

idea {
    module {
        downloadJavadoc = true
    }
}
```
