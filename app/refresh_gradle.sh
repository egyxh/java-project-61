#!/bin/bash
set -e

# Полная очистка
rm -rf .gradle build ~/.gradle/caches/

# Инициализация проекта
./gradlew --stop
./gradlew clean
./gradlew assemble --refresh-dependencies