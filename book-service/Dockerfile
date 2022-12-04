FROM openjdk:17
WORKDIR /app
ARG JAR_FILE=target/book-service.jar
COPY ${JAR_FILE} book-service.jar
ENTRYPOINT ["java", "-jar", "book-service.jar"]