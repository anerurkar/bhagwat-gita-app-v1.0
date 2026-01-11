FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY target/*.jar /app/bservices.jar
ENTRYPOINT ["java", "-jar", "bservices.jar"]
