#!/bin/sh
# Create deployment package for backend with Docker
# Should be run after backend is built

rm -rf deploy
mkdir deploy
tar -czvf deploy.tar.gz frontend/ backend/Dockerfile backend/mongo-seed/cpus.json backend/mongo-seed/Dockerfile backend/build/libs/ ./buildRunDocker.sh ./docker-compose.yml ./init-letsencrypt.sh ./server/
mv deploy.tar.gz ./deploy/
echo deploy/deploy.tar.gz created
