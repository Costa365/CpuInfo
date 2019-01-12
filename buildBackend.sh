#!/bin/sh
cd backend
./gradlew build
./createjson.sh
cd ..
