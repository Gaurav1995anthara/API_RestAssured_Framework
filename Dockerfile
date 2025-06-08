# Use Maven with OpenJDK 11 as the base image
FROM maven:3.9.6-eclipse-temurin-21

# Set the working directory inside the container
WORKDIR /app

# Copy only the pom.xml first to leverage dependency caching
COPY pom.xml .

# Download project dependencies (cached unless pom.xml changes)
RUN mvn dependency:go-offline -B

# Now copy the rest of the source code
COPY src ./src

# Package the application skipping tests
RUN mvn clean package -DskipTests=true -B

# Set the default command to run tests
CMD ["mvn", "test"]

#give this to some person to run in this system with the report
#docker run --rm -v C:\localdocreport:/app/target gauravanthara/apiframework:1 mvn test -Dsurefire.suiteXmlFiles=src/test/resources/testRunners/testng_regression.xml