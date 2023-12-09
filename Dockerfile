# Build stage
FROM gradle:8.5.0-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle clean build -x test

FROM eclipse-temurin:17
COPY --from=build /app/build/libs/hamster-server-0.0.1-SNAPSHOT.jar .
EXPOSE 8443
ENTRYPOINT ["java","-jar","/hamster-server-0.0.1-SNAPSHOT.jar"]