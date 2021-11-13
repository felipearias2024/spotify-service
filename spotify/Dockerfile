FROM openjdk
MAINTAINER felipe2arias@hotmail.com
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} spotify.jar
ENTRYPOINT {"java", "-jar", "/spotify.jar"}