FROM openjdk:17-jdk-alpine

EXPOSE 8080

COPY target/RestApplication-0.0.1.jar restApp.jar

CMD ["java", "-jar", "restApp.jar"]
