#!/bin/bash
cd mega
rm -rf ./bin
mkdir ./bin
javac -d ./bin mega.java
cd bin
java mega
mv ./cpus.json ../../mongo-seed/
cd ../..
