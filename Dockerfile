FROM openjdk:17

EXPOSE 8081

COPY build/libs/*.jar /

ENTRYPOINT [ "java", "-jar", "/UltimateStore-1.0-SNAPSHOT" ]
