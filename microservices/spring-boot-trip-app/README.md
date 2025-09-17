# Spring Boot Trip Application

This is a Spring Boot application that manages trips. It provides RESTful API endpoints to create and retrieve trip information.

## Project Structure

```
spring-boot-trip-app
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── trip
│   │   │               ├── TripApplication.java
│   │   │               ├── controller
│   │   │               │   └── TripController.java
│   │   │               ├── entity
│   │   │               │   └── Trip.java
│   │   │               ├── repository
│   │   │               │   └── TripRepository.java
│   │   │               └── service
│   │   │                   └── TripService.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── trip
│                       └── TripApplicationTests.java
├── pom.xml
└── README.md
```

## Features

- **Trip Entity**: Represents a trip with attributes such as id, title, description, and price.
- **REST API**:
  - `GET /trips`: Retrieve all trips.
  - `POST /trips`: Create a new trip.

## Getting Started

1. Clone the repository.
2. Navigate to the project directory.
3. Run the application using the command:
   ```
   mvn spring-boot:run
   ```
4. Access the API endpoints using a tool like Postman or curl.

## Dependencies

This project uses Maven for dependency management. The required dependencies are specified in the `pom.xml` file, including Spring Boot and JPA.

## License

This project is licensed under the MIT License.