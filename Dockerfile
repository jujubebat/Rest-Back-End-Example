FROM ubuntu:18.04
COPY  target/Rest-Back-End-Example-*.jar app.jar
RUN apt-get update
RUN apt install openjdk-8-jdk -y
ENTRYPOINT ["java", "-jar", "app.jar"]

