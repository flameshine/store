FROM openjdk:17

MAINTAINER Anton Pokhyla excellenceissoon@gmail.com

ARG HOME=/opt/store
ARG USERNAME=store

# Create a base directory
RUN mkdir -p $HOME

# Set timezone to the known value for clarity
RUN ln -sf /usr/share/zoneinfo/UTC /etc/localtime

# Create an unprivileged user for the application
RUN groupadd -r $USERNAME
RUN useradd -l -r -g $USERNAME $USERNAME
RUN chown -R $USERNAME:$USERNAME $HOME

# Copy the build artifacts
COPY build/libs/store-1.0-SNAPSHOT.jar $HOME/
COPY scripts/wait-for-it.sh $HOME/scripts/

USER $USERNAME
WORKDIR $HOME

EXPOSE 8081

ENTRYPOINT [ "./scripts/wait-for-it.sh", "database:3306", "--", "java", "-jar", "store-1.0-SNAPSHOT.jar" ]