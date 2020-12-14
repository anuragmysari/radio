# radio
# Project for Spring Boot using Gradle

REST service, built with Spring Boot, to allow end-users to pull station data. Makes use of the following:

 - Gradle
 - Swagger
 - Jacoco
 - Junit
 - Accuator
 - H2 Database
 - MyBatis(ORM)

Application is dockerized, with 100% code coverage

# Application Setup/Info

-   Import as Gradle project into Eclipse IDE.
-   Build the application using **gradle clean build** at the project root directory.
-   Run the application as a Java Application.
-   Application is configured locally on port 8080 with actuator exposed at http://localhost:8081/actuator/
-   H2 Database console is exposed at http://localhost:8080/h2/. StationId and Name fields are indexed.
-   Corresponding Swagger API documentation can be found at  http://localhost:8080/swagger-ui/index.html
-   Jacoco test reports are found at build/jacoco/test/html/index.html of the project root directory.
