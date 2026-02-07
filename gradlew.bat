\
@echo off
setlocal enabledelayedexpansion

set APP_HOME=%~dp0
set WRAPPER_JAR=%APP_HOME%gradle\wrapper\gradle-wrapper.jar

if not exist "%WRAPPER_JAR%" (
  echo ERROR: Missing %WRAPPER_JAR%
  echo Open this project in Android Studio (it will regenerate wrapper), or add the wrapper jar.
  exit /b 1
)

set JAVA_EXE=java
if not "%JAVA_HOME%"=="" if exist "%JAVA_HOME%\bin\java.exe" set JAVA_EXE="%JAVA_HOME%\bin\java.exe"

%JAVA_EXE% -jar "%WRAPPER_JAR%" %*
