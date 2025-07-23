FROM maven:3.9.6-eclipse-temurin-17 AS build
COPY pom.xml .
COPY src ./src


FROM openjdk:17
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]