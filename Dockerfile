# to create an image execute: docker build -t ultimate-store .

FROM openjdk:11
EXPOSE 8081
MAINTAINER flameshine
COPY build/libs/UltimateStore-1.0-SNAPSHOT.jar ultimate-store.jar
ENTRYPOINT ["java", "-jar", "/ultimate-store.jar"]