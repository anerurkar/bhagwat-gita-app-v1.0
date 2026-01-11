FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY target/*.jar /app/gita-api.jar
ENTRYPOINT ["java", "-jar", "gita-api.jar"]
