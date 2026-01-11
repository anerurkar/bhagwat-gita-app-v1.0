FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY target/*.jar /app/Bgita-api.jar
EXPOSE 8080 # Expose the port your Spring Boot app runs on
ENTRYPOINT ["java", "-jar", "Bgita-api.jar"]
