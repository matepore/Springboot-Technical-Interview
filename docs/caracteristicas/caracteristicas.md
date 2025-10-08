# Características Técnicas

Esta sección describe las tecnologías, dependencias y configuraciones principales del proyecto **Springboot-Technical-Interview**.

---

## 1. Framework Principal

- **Spring Boot 3.5.5**
    - Simplifica la configuración y despliegue de aplicaciones Java.
    - Permite integración rápida con JPA, Redis, Thymeleaf y validaciones.

---

## 2. Lenguaje y Versión de Java

- **Java 21**
    - Se utiliza como versión del JDK para todo el proyecto.
    - Aprovecha nuevas características de lenguaje y rendimiento optimizado.

---

## 3. Base de Datos

- **PostgreSQL**
    - Base de datos relacional principal.
    - Configuración en `application.properties`:
      ```properties
      spring.datasource.url=jdbc:postgresql://localhost:5432/db_persons
      spring.datasource.username=username
      spring.datasource.password=supercontraseniasecreta
      spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.show-sql=true
      ```
- **JPA / Hibernate**
    - Mapeo objeto-relacional.
    - Permite operaciones CRUD y consultas SQL personalizadas.

---

## 4. Cache y Almacenamiento en Memoria

- **Redis**
    - Almacenamiento en memoria para caching de datos.
    - Configuración en `application.properties`:
      ```properties
      spring.redis.host=localhost
      spring.redis.port=6379
      spring.cache.type=redis
      ```

---

## 5. Interfaz Web

- **Spring Web**
    - Implementa endpoints REST y MVC.
- **Thymeleaf**
    - Motor de plantillas para páginas web dinámicas.
- **Bootstrap**
    - Se utiliza en los templates para estilos responsivos y consistentes.

---

## 6. Documentación

- **MkDocs Material**
    - Documentación generada con Markdown.
    - Servida en contenedor Docker en `http://localhost:8000`.
- **springdoc-openapi**
    - Genera documentación automática de la API REST.
    - Interfaz interactiva disponible para probar endpoints.

---

## 7. Validación y Desarrollo

- **Spring Boot Validation**
    - Validación de DTOs y formularios.
- **Lombok**
    - Reduce boilerplate (getters, setters, builders).
- **Spring Boot DevTools**
    - Hot reload para desarrollo más rápido.

---

## 8. Testing

- **Spring Boot Starter Test**
    - Framework de pruebas unitarias y de integración.
    - Incluye JUnit, Mockito y Spring Test Utilities.

---

## 9. Dependencias Clave

| Dependencia | Propósito |
|-------------|-----------|
| spring-boot-starter-web | Endpoints REST y MVC |
| spring-boot-starter-data-jpa | Integración con JPA/Hibernate |
| spring-boot-starter-data-redis | Cache en Redis |
| spring-boot-starter-thymeleaf | Renderizado de vistas web |
| spring-boot-starter-validation | Validaciones de formularios y DTOs |
| springdoc-openapi-starter-webmvc-ui | Documentación OpenAPI |
| lombok | Generación de getters/setters/builders automáticos |
| postgresql | Driver JDBC para PostgreSQL |
| spring-boot-devtools | Hot reload en desarrollo |
| spring-boot-starter-test | Testing con JUnit y Mockito |

---

## 10. Estructura General del Proyecto

