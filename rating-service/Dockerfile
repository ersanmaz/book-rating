FROM openjdk:17
WORKDIR /app
ARG JAR_FILE=target/rating-service.jar
COPY ${JAR_FILE} rating-service.jar
ENTRYPOINT ["java", "-jar", "rating-service.jar"]