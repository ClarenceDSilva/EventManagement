#
# Build stage
#
FROM maven:3.8.6-openjdk-18 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:18-jdk-alpine3.14
COPY --from=build /home/app/target/eventmanagement-0.0.1-SNAPSHOT.jar /usr/local/lib/eventmanagement.jar
#ADD target/eventmanagement*.jar eventapi.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/eventmanagement.jar"]