#!/bin/sh
cd server
./gradlew build
./createjson.sh
cd ..
