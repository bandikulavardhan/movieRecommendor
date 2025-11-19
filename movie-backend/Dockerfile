# Start with a small, lightweight Java 17 environment
FROM openjdk:17

# Copy the JAR file we just built (The name of the JAR file is exactly this)
COPY target/movierecommender-0.0.1-SNAPSHOT.jar app.jar

# Tell the container which port to use
EXPOSE 8080

# This is the command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "/app.jar"]