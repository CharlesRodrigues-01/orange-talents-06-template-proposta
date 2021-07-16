FROM openjdk:11
MAINTAINER Charles Rodrigues
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} desafio-proposta.jar
ENTRYPOINT ["java","-jar","/desafio-proposta.jar"]
