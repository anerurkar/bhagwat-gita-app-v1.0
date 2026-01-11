FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar /app/gita-api.jar
ENTRYPOINT ["java", "-jar", "gita-api.jar"]
