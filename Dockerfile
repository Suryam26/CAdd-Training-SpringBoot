FROM openjdk:17
MAINTAINER baeldung.com
COPY target/DockerTraining-0.0.1-SNAPSHOT.jar Training-0.0.1.jar
ENTRYPOINT ["java","-jar","/Training-0.0.1.jar"]