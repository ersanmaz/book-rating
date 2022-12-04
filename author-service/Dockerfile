FROM openjdk:17
WORKDIR /app
ARG JAR_FILE=target/author-service.jar
COPY ${JAR_FILE} author-service.jar
ENTRYPOINT ["java", "-jar", "author-service.jar"]