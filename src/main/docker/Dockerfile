# Use the official OpenJDK base image for Java 17
FROM openjdk:22-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR into the container
COPY ./artifact/travel_agency_spring_mvp_app-1.0.0.jar /app/app.jar

# Document that the service listens on port 8080
EXPOSE 8080

# Specify the default command to run the JAR
CMD ["java", "-jar", "/app/app.jar"]