# Use an appropriate base image with Java and Maven
FROM maven:3-sapmachine-21 AS build

# Set the working directory
WORKDIR /app

# Copy the project files into the Docker container
COPY . .

# Run tests and generate the Allure report
RUN mvn clean package -DskipTests

# Set the entrypoint to keep the container running
ENTRYPOINT ["mvn", "clean", "test", "allure:report"]