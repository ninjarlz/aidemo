FROM gradle:7.6.1-jdk17-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

ARG profile
FROM eclipse-temurin:17
ENV TZ="Europe/Warsaw"
EXPOSE 8080
COPY --from=build /home/gradle/src/build/libs/aidemo-0.0.1-SNAPSHOT.jar /usr/bin/aidemo/app.jar
WORKDIR /usr/bin/aidemo
CMD ["java", "-Dspring.profiles.active=ollama,dev", "-jar", "./app.jar"]