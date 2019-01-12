#!/bin/bash
mkdir -p data/nginx
cp ./server/docker-compose.yml.getcertif ./docker-compose.yml
cp ./server/app.conf.getcertif ./data/nginx/app.conf

sudo ./init-letsencrypt.sh

cp ./server/docker-compose.yml ./docker-compose.yml
cp ./server/app.conf ./data/nginx/app.conf

