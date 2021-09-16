# to create an image execute:
# docker build -t ultimate-store <path>

FROM openjdk:11
EXPOSE 8081
COPY build/libs/UltimateStore-1.0-SNAPSHOT.jar ultimate-store.jar
ENTRYPOINT [ "java", "-jar", "/ultimate-store.jar" ]