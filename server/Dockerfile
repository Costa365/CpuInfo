FROM wrlennon/alpine-java8-jdk

COPY ./build/libs/cpuinfo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
