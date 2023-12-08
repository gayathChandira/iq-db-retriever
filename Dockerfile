# Use an official OpenJDK runtime as a parent image
FROM public.ecr.aws/z8p2n0n3/amazon-corretto-17:latest

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY target/iq-db-retriever-1.0.jar /app

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "iq-db-retriever-1.0.jar"]
