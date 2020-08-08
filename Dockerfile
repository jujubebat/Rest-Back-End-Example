FROM openjdk:8-jre
COPY  target/Rest-Back-End-Example-*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

