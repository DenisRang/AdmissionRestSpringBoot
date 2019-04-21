FROM openjdk:8
ADD target/admission-rest-0.0.1-SNAPSHOT.jar admission-rest-0.0.1-SNAPSHOT.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "admission-rest-0.0.1-SNAPSHOT.jar"]