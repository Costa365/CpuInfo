# CPUInfo

Display CPU benchmark information.

Docker, docker compose and Java 8 are required. Build and run as follows:

```console
$ buildBackend.sh
$ buildDeployment.sh 
$ scp ./deploy/deploy.tar.gz costa@costa365.pserver.ru:/home/costa 
$ ssh costa@costa365.pserver.ru
remote: cd cpuinfo
remote: docker-compose down
remote: cd ..
remote: sudo mv cpuinfo/ cpuinfo.bak/
remote: mkdir cpuinfo
remote: tar -xzvf deploy.tar.gz -C ./cpuinfo
remote: cd cpuinfo
```
Extra complications for SSL:
```console
./createCertif.sh
mkdir -p bin data/nginx

remote: docker-compose up --build -d
```
If you only have client changes, can just copy them, no need for all this...

