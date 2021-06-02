FROM openjdk:11
LABEL maintainer="hernandes_sp@yahoo.com.br"

ENV RELEASE 27-05-2021-2050
ENV VERSION 1.0.0

RUN mkdir /opt/api-compra-mysql

ENV DEPLOYMENT_JAR /opt/api-compra-mysql

COPY target/api-compra-mysql.jar $DEPLOYMENT_JAR

ENTRYPOINT exec java -jar $DEPLOYMENT_JAR/api-compra-mysql.jar
