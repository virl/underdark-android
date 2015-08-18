# Underdark for Android
Peer-to-peer networking library for Android, with Wi-Fi and Bluetooth support.
## Author
You can contact me at http://telegram.me/virlof

##License
This library can be is for non-commercial and educational purposes only.
If you want to use it in your products, please contact the author.

##Features
Please note that for Bluetooth connection to work, one of the phones must have Android 5.x AND support Bluetooth LE Peripheral mode (have "yes" in last column here: http://altbeacon.github.io/android-beacon-library/beacon-transmitter-devices.html).

1. Allows apps on mobile devices to auto-discover and connect to each other via Wi-Fi and Bluetooth without any intervention from the user and without using any Internet connection.;

2. Works both in foreground and background app modes;

3. Allows asynchronous transfer of messages, photos and sounds — all without freezing the UI of the app;

4. Apps can discover other users of the app nearby — without using GPS or Internet.

5. Routes messages from Wi-Fi to Bluetooth-connected devices and vice versa — so devices with turned off Wi-Fi will receive all the same data via Bluetooth.

6. Work between Android and iPhone via infrastructure Wi-Fi.

7. Doesn’t eat battery.

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
