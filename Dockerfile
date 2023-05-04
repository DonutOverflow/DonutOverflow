# Use the official Maven image as the base image
FROM maven:3.8.1-openjdk-11 AS build

# Set the working directory in the container
WORKDIR /app

# Copy pom.xml to the working directory
COPY pom.xml .

# Download dependencies to cache them in a separate Docker layer
RUN mvn -B dependency:go-offline

# Copy the source code to the working directory
COPY src ./src

# Build the application
RUN mvn -B clean package

# Use the official OpenJDK image as the runtime base image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /DonutOverflow

# Copy the built artifact from the build stage
COPY --from=build /DonutOverflow/target/project-0.0.1-SNAPSHOT.jar /DonutOverflow/project-0.0.1-SNAPSHOT.jar

# Expose the port the application will run on
EXPOSE 8080

# Start the application
CMD ["java", "-jar", "project-0.0.1-SNAPSHOT.jar"]
