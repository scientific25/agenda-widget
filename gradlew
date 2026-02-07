#!/usr/bin/env sh
# Minimal Gradle wrapper script (Unix)
# Generated for this template repo.

set -eu

APP_HOME=$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)
WRAPPER_JAR="$APP_HOME/gradle/wrapper/gradle-wrapper.jar"
PROPS="$APP_HOME/gradle/wrapper/gradle-wrapper.properties"

if [ ! -f "$WRAPPER_JAR" ]; then
  echo "ERROR: Missing $WRAPPER_JAR"
  echo "Open this project in Android Studio (it will regenerate wrapper), or add the wrapper jar."
  exit 1
fi

JAVA_EXEC="${JAVA_HOME:-}/bin/java"
if [ ! -x "$JAVA_EXEC" ]; then
  JAVA_EXEC="java"
fi

exec "$JAVA_EXEC" -jar "$WRAPPER_JAR" "$@"
