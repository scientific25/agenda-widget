This repo includes gradle-wrapper.properties but does NOT include gradle-wrapper.jar (binary).
Two easy options:
1) Open the project in Android Studio. It can regenerate/repair the wrapper.
2) From a machine with Gradle installed, run: gradle wrapper --gradle-version 8.2
Then commit gradle/wrapper/gradle-wrapper.jar
