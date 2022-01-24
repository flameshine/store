FROM openjdk:17

MAINTAINER Anton Pokhyla excellenceissoon@gmail.com

ARG HOME=/opt/ultimate-store

COPY build/libs/ultimate-store-1.0-SNAPSHOT.jar $HOME/
COPY scripts/wait-for-it.sh $HOME/scripts/

WORKDIR $HOME

EXPOSE 8081

ENTRYPOINT [ "./scripts/wait-for-it.sh", "database:3306", "--", "java", "-jar", "ultimate-store-1.0-SNAPSHOT.jar" ]