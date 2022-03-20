# Thaumic Industries
A WIP magic mod.

remember to pray to ![anuke logo](https://cdn.discordapp.com/avatars/123539225919488000/367d4922fe78713f58b1afd8a097de9a.webp "anuke our savior")

## Content
Currently adds:

* Vinteum ore nodes, which can be drilled for some reason?
* Vinteum extractor, which requires water to extract vinteum solution from ore
* Evaporator, which turns Vinteum solution into Vinteum.
* Vinteum, which is useless.
* Managlass, which cannot be made and is useless.
*cri*

will work on this more after exams


## Building from source

1. Install JDK **17**. Or 16 might work too.
2. Run `gradlew jar` [1].
3. Your mod jar will be in the `build/libs` directory. **Only use this version for testing on desktop. It will not work with Android.**
To build an Android-compatible version, you need the Android SDK. You can either let Github Actions handle this, or set it up yourself. See steps below.

## Building for Android Locally

Building locally takes more time to set up, but shouldn't be a problem if you've done Android development before.
1. Download the Android SDK, unzip it and set the `ANDROID_HOME` environment variable to its location.
2. Make sure you have API level 30 installed, as well as any recent version of build tools (e.g. 30.0.1)
3. Add a build-tools folder to your PATH. For example, if you have `30.0.1` installed, that would be `$ANDROID_HOME/build-tools/30.0.1`.
4. Run `gradlew deploy`. If you did everything correctlly, this will create a jar file in the `build/libs` directory that can be run on both Android and desktop. 

--- 

*[1]* *On Linux/Mac it's `./gradlew`, but if you're using Linux I assume you know how to run executables properly anyway.*  
