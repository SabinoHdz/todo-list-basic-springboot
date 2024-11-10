# Use the Eclipse temurin alpine official image
# https://hub.docker.com/_/eclipse-temurin
FROM eclipse-temurin:21-jdk-alpine

# Create and change to the app directory.
WORKDIR /app
# Copy the application jar file to the container.
COPY target/*.jar app.jar

#Configure the port that the container should expose
EXPOSE 8080

#command to run the application
CMD ["java", "-jar", "app.jar"]