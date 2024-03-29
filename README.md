# Event Management Application
A Java springboot application for creating REST APIs for event management

## Features
* Operations for Creating, Reading, Updating and Deleting Events
* Operations for adding a Guest to an Event
* Operation to view all the Events in a City
* API responses also features current weather of the city obtained from [openweather.org](https://openweathermap.org/)
* All APIs are connected through an in-memory H2 database

## Steps to run the project

**Prerequisite:** Since the API relies on weather information from openweather.org, an API key needs to be created first.
Visit [openweather.org](https://openweathermap.org/), create your account first before creating an API key.
It usually takes a couple of hours before your api key gets activated so please wait before running your requests.

The project can be build executed via maven build on the project directory or by simply executing the **Dockerfile** command.
The steps to both are explained below

1. **Running locally through maven build**
* Locate the directory of the project containing pom.xml
* Run the following commands in order
``` shell
mvn clean install -DskipTests
```

```shell
mvn spring-boot:run -Dspring-boot.run.arguments=--api.key=<add_your_api_key_here>
```
* Once the server starts, all your requests should go through the port 8080
* Kindly check the **[Swagger Documentation](http://localhost:8080/swagger-ui.html/)** for the various API endpoints

2. **Running via Dockerfile**
* **Prerequisite:** Before you run the Dockerfile, you need to add your api key in the **application.properties** file at the **api.key** field. This will automatically connect your API calls to the weather API
* Locate the directory where the **Dockerfile** is present and the run the following commands in order
``` shell
docker build -t eventmanagement.jar .
```

``` shell
docker run -p 9090:8080 eventmanagement.jar
```
* Once the server starts, all your requests should go through the port 9090
* Kindly check the **[Swagger Documentation](http://localhost:9090/swagger-ui.html/)** to view the various API endpoints 

## Testing the APIs
* You may use any REST API client such as [Postman](https://www.postman.com/)

## Tech stack and tools used
* Java 18
* Maven 3.8.6
* H2 Database
* Swagger UI
* Docker
* Postman
