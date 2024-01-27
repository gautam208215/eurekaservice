# Use an official OpenJDK runtime as a base image
FROM openjdk:17-oracle

# Set the working directory inside the container

WORKDIR /app

# Copy the JAR file into the container at /app
COPY  ./target/service.eureka-0.0.1-SNAPSHOT.jar /app/service.eureka-0.0.1-SNAPSHOT.jar

# Specify the command to run on container startup
CMD ["java", "-jar", "service.eureka-0.0.1-SNAPSHOT.jar"]