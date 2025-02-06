# Wiindur
A simple overhaul mod called wiindur.


the android support is currently turned off, but can be turned on by changing deploy task in ```build.gradle```.

## Contents
- [Building](#building)
    - [Tools](#tools)
    - [Getting the source code](#getting-the-source-code-and-tools)
        - [The source code](#the-source-code)
        - [Java/JDK](#javajdk)
    - [Installing/Building](#installingbuilding)
- [Content](#content)

# Building
Building the mod on your own

## Tools
tools you need to build the mod

* Java/JDK
* Android SDK(Optional, enabled in ```build.gradle```)

## Getting the source code and tools

### The source code
the commands to retreive the source code
```sh
git clone https://github.com/vladisaev12/wiindur.git
cd wiindur
```

### Java/JDK
you can download it from [here](https://www.oracle.com/java/technologies/downloads/) or build it from [here](https://github.com/openjdk/jdk).

### Android SDK
the setup page is [here](https://developer.android.com/about/versions/11/setup-sdk#get-sdk).

## Installing/Building
the main way to build the project is:
* linux(no steam):
```sh
./gradlew deploy
cp path-to-wiindur/build/libs/wiindur.jar ~/.local/share/Mindustry/mods/
```
* linux(no steam):
```sh
./gradlew deploy
cp path-to-wiindur/build/libs/wiindur.jar ~/.steam/steamapps/common/Mindustry/saves/mods/
```
* linux(no steam):
```sh
./gradlew deploy
cp path-to-wiindur/build/libs/wiindur.jar ~/Library/Application\ Support/Mindustry/mods/
```
* windows:
```psh
gradlew.bat "deploy"
COPY "path-to-wiindur\build\libs\wiindur.jar" "%appdata%/Mindustry/mods/"
```

## Content
* template wall(currently a retextured copper wall)
* steam generator(currently not used) 