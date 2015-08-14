# Underdark for Android
## Installation
First, just add underdark repository in your root's (or module's) build.gradle:
```
repositories {
    maven {
        url 'https://dl.bintray.com/glint/maven/'
    }
}
```
Next, add Underdark library dependency:
```
dependencies {
    compile ('io.underdark:underdark:1.0.1@aar') { transitive = true }
}
```
