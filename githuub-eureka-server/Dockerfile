FROM openjdk:8-jdk-alpine
WORKDIR usr/github-eureka-server
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
