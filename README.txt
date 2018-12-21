# CPUInfo

Display CPU benchmark information.

Docker, docker compose and Java 8 are required. Build and run as follows:

```console
$ buildServer.sh
$ buildDeployment.sh
$ scp ./build/libs/cpuinfo-0.0.1-SNAPSHOT.jar  costa@costa365.pserver.ru:/home/costa 
$ ssh costa@costa365.pserver.ru
remote: rm -rf deploy
remote: mkdir deploy
remote: mv deploy.tar deploy
remote: cd deploy
remote: tar -xvf deploy.tar
remote: rm deploy.tar
remote: docker-compose up --build -d
```

