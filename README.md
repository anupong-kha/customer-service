
# Customer Service API with JWT Authentication

This project is a Spring Boot-based microservice for managing customers, offering CRUD operations (Create, Read, Update, Delete). It features JWT-based authentication and authorization for securing the API endpoints.

## Features

- **JWT Authentication**: Secure the API with stateless JWT tokens.
- **CRUD Operations**: Manage customer data with Create, Read, Update, and Delete endpoints.
- **H2 In-Memory Database**: Quick and easy testing with an in-memory database.
- **Exception Handling**: Centralized error handling using `@ControllerAdvice`.

## Technologies Used

- **Spring Boot** (version 3.x)
- **Spring Security** (for authentication and authorization)
- **JWT** (for token-based security)
- **Spring Data JPA** (for data access)
- **H2 Database** (in-memory database for testing)
- **JUnit & Mockito** (for unit testing)
- **Lombok** (to reduce boilerplate code)

---

## Prerequisites

- **Java 21**
- **Gradle** or **Maven** (Gradle is used in this project)
- **Postman** or **Curl** (for testing the API)

---

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/anupong-kha/customer-service-api.git
cd customer-service-api
```

### 2. Set up Environment Variables

Set the JWT secret key by configuring an environment variable or updating the `application.properties` file. You can generate a secure key for JWT as shown below.

```bash
# Example of setting the environment variable
export JWT_SECRET_KEY=your-base64-encoded-secret-key
```

Alternatively, you can add it to the `src/main/resources/application.properties` file:
```properties
jwt.secret=your-base64-encoded-secret-key
```

### 3. Build and Run the Project

To run the project, use the following Gradle commands:

```bash
./gradlew clean build
./gradlew bootRun
```

---

## API Documentation

The following endpoints are available:

### Authentication

- **POST /api/auth/login**: Authenticate the user and receive a JWT token.

  **Request**:
  ```json
  {
    "username": "user",
    "password": "password"
  }
  ```

  **Response**:
  ```
    Token : "Field Authorization in Header"
  ```
### Customer Management (Secured)

You need to pass the JWT token in the `Authorization` header for the secured customer endpoints.

Example:
```http
Authorization: Bearer your-jwt-token
```

- **GET /api/customers**: Retrieve all customers.
- **GET /api/customers/{id}**: Retrieve a specific customer by ID.
- **POST /api/customers**: Create a new customer.

  **Request**:
  ```json
  {
    "name": "John Doe",
    "email": "john.doe@example.com",
    "address": "123 Main St"
  }
  ```

- **PUT /api/customers/{id}**: Update an existing customer by ID.
- **DELETE /api/customers/{id}**: Delete a customer by ID.

---

## Unit Testing

The project includes unit tests written using JUnit and Mockito. You can run the tests with:

```bash
./gradlew test
```

The goal is to maintain **90%+ test coverage** with unit tests for the service and controller layers.

---

## Security

This project uses **JWT** for stateless authentication, ensuring that each request includes a valid token for accessing secured endpoints.

To enhance security:
- Store the JWT secret key securely in environment variables.
- Ensure that the token expires after a reasonable period (e.g., 15 minutes) and use refresh tokens if necessary.
- Use HTTPS in production.

---

## Future Enhancements

- **Role-based Authorization**: Assign roles to users and restrict access to certain endpoints based on roles.
- **Database Migration**: Integrate Liquibase or Flyway for database versioning.
- **Dockerization**: Containerize the application for deployment.

---

## Contributing

Feel free to fork the project and submit pull requests. For major changes, please open an issue first to discuss what you would like to change.

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## Contact

For any issues or questions, feel free to reach out via GitHub or email me at [anupong.kha2539@gmail.com].
