# etapa 1: compilación
#revisar si esta ver de java esta bn y es compatible con la q uso para compilar el proyecto
FROM maven:3.8.5-openjdk-17 AS build
workdir /app
COPY  . .
RUN mvn -f pom.xml clean package -DskipTests
#estapa 2 creacion imagen final
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
copy --from=build /app/target/*.jar ./app.jar
expose 8080
entrypoint ["java", "-jar", "app.jar"]