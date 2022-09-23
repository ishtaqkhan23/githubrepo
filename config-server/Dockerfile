FROM openjdk:8-jdk-alpine
WORKDIR usr/config-server
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
# COPY src/main/resources/* usr/config-server/
VOLUME ${HOME}/centralproperties
ENV SPRING_APPLICATION_JSON='{"spring": {"cloud": {"config": {"server": \
    {"git": {"uri": "https://gitlab.stackroute.in/Ishtaq.Dalazak/centralproperties.git","username":"ishtaq.dalazak","password":"HatimHatim@1","clone-on-start": true}}}}}}'
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8084
