# Springboot Technical Interview

This project is a Spring Boot application for a technical interview.

It has:
- **H2** Database in local memory.
- **Controller**, **DTO**, **Entity**, **Repository** and **Service** layers.
- Personalized exceptions.
- Logs.

---

## Technologies Used
- JDK 21
- Spring Boot 3.5.5
- Maven
- H2 Database
- Lombok
- IntelliJ Community Edition 2025 IDE

---

## How to use the project
- Clone the repository.
- Make sure you have JDK 21 installed.
- Open the folder of the project with IntelliJ or the java IDE of your preference.
- Use the package function of the lifecycle of Maven.
- Run the .jar file in the target folder of the project.

## Useful stuff
- **H2 Console**: `localhost:8080/h2-console`
    - The login information is in the application.properties file in the resource folder.
- **API REST**: `localhost:8080/api/persons` and `localhost:8080/api/wallets`

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