# Use the official maven/Java 8 image to create a build container
FROM maven:3.8.2-openjdk-8 as build

# Set the working directory
WORKDIR /app

# Copy the pom.xml file
COPY pom.xml .

# Download the dependencies
RUN mvn dependency:go-offline

# Copy the src directory
COPY src /app/src

# Build the project
RUN mvn clean package

# Use the official openjdk image as a parent image
FROM openjdk:8-jre-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port your app runs on
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "app.jar"]
