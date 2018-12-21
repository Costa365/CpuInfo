#!/bin/sh
# Create deployment package for sever with Docker
# Should be run after server is built

rm -rf deploy
mkdir deploy
tar -cf deploy.tar client/ server/Dockerfile server/mongo-seed/cpus.json server/mongo-seed/Dockerfile server/build/libs/ ./buildRunDocker.sh docker-compose.yml
mv deploy.tar ./deploy/
echo deploy/deploy.tar created