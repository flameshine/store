FROM openjdk:17

MAINTAINER Anton Pokhyla excellenceissoon@gmail.com

EXPOSE 8081

COPY ./build/libs/*.jar /
COPY ./scripts/wait-for-it.sh /

ENTRYPOINT [ "./wait-for-it.sh", "database:3306", "--", "java", "-jar", "/UltimateStore-1.0-SNAPSHOT.jar" ]