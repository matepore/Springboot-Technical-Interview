# Springboot Technical Interview

This project is a Spring Boot application for a technical interview.

# Technical Features

This section describes the features, dependencies and configurations that the project **Springboot-Technical-Interview** has.

---

## 1. Primary Framework

- **Spring Boot 3.5.5**
    - It simplifies the configuration and deployment of java applications.
    - Allows fast integration with JPA, Redis, Thymeleaf y validations.

---

## 2. Language and Version

- **Java 21**
    - Is being used as the jdk enviroment of the complete project.
    - This project uses some of the most new additions that Java 21 has to offer.

---

## 3. Database

- **PostgreSQL**
    - Primary relational database.
    - Configuration in `application.properties`:
      ```properties
      spring.datasource.url=jdbc:postgresql://localhost:5432/db_persons
      spring.datasource.username=username
      spring.datasource.password=supercontraseniasecreta
      spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.show-sql=true
      ```
- **JPA / Hibernate**
    - Is being use as a language to map objects to relational databases.
    - It allows CRUD tasks y personalized SQL queries.

---

## 4. Cache and Memory Storage

- **Redis**
    - Is used as a local memory storage database that is extremely low cost and light, it stores only data.
    - Configuration in `application.properties`:
      ```properties
      spring.redis.host=localhost
      spring.redis.port=6379
      spring.cache.type=redis
      ```

---

## 5. Web Interface

- **Spring Web**
    - Implements REST and MVC endpoints.
- **Thymeleaf**
    - Web template engine for dynamic websites.
- **Bootstrap**
    - Is used in the websites as a framework to generate good looking and responsive websites.

---

## 6. Documentation

- **MkDocs Material**
    - Allows for markdown documentation.
    - Is being included through a Docker container `http://localhost:8000`.
- **springdoc-openapi**
    - It creates automatic documentation for the API REST.
    - Interactive interface that allow endpoint testing.

---

## 7. Validation and Development

- **Spring Boot Validation**
    - Validation of DTOs and forms.
- **Lombok**
    - It reduces writing of basic structures of objects (getter, setter, constructor, builder).
- **Spring Boot DevTools**
    - Hot reload for a fast development.

---

## 8. Testing

- **Spring Boot Starter Test**
    - Framework of unit and integration tests.
    - Includes JUnit, Mockito and Spring Test Utilities.

---

## How to use the project
- Clone the repository.
- Make sure you have JDK 21 installed.
- Open the folder of the project with IntelliJ or the java IDE of your preference.
- Use the package function of the lifecycle of Maven.
- Run the .jar file in the target folder of the project.

## Useful stuff
- **API REST**: `localhost:8080/api/persons` and `localhost:8080/api/wallets`
- **Open Api Swagger**: `localhost:8080/swagger-ui/index.html#/`
- **Thymeleaf Web CRUD**: `localhost:8080/login`

### Endpoints

| Method |  Endpoints  | Description |
|:-----|:--------:|:------:|
| GET   | `/api/persons` | List all the persons |
| GET   |  `/api/persons/{id}`  |   Obtains a person matching the id |
| GET   | `/api/wallets` |    List all the wallets |
| GET   | `/api/wallets/{id}` |    Obtains a wallet matching the id |
| POST   | `/api/persons` |    Creates a new person |
| POST   | `/api/wallets` |    Creates a new wallet |
| PUT   | `/api/persons/{id}` |    Modifies an existing person |
| PUT   | `/api/wallets/{id}` |    Modifies an existing wallet |
| DELETE   | `/api/persons/{id}` |    Deletes a person by an id |
| DELETE   | `/api/wallets/{id}` |    Deletes a wallet by an id |

Made by Matepore.