FROM sbtscala/scala-sbt:eclipse-temurin-jammy-17.0.5_8_1.9.0_2.13.11

WORKDIR /usr/app

# In order to docker container hot-reaload when code change, we don't copy source code to container. We'll mount source code into container use volumes in docker-compose.yml
#COPY ./ ./
#
#RUN ["sbt", "compile"]

CMD ["sbt", "~reStart"]
