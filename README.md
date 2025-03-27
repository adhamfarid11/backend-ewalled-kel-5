# README: How to Start the Spring Project

## Project Name: `Backend E-Walled`

### Overview

This project is a Spring Boot application designed to `fulfil the rakamin assignment`. The project is fully set up, and this guide will help you run it smoothly.

---

## Prerequisites

-   **Java Development Kit (JDK)**: Version `17` or higher
-   **Maven**: Version `3.8` or higher
-   **Database**: `H2 Database`

---

## How to Start the Project

### 1. Clone the Repository

```bash
git clone [https://github.com/adhamfarid11/backend-ewalled-kel-5]
```

### 2. Set Up Environment Variables

Ensure the following environment variables are configured:

```env
DB_URL=[Your Database URL]
DB_USERNAME=[Your Database Username]
DB_PASSWORD=[Your Database Password]
JWT_SECRET=[Your JWT Secret (if applicable)]
```

### 3. Build the Project

Run the following command to clean and build the project:

```bash
./mvnw clean install
```

### 4. Run the Project

To start the Spring Boot application, execute:

```bash
./mvnw spring-boot:run
```

Or run the `Application.java` file directly from your IDE.

---

## Access the Application

-   **Local URL**: `http://localhost:8080`

---

## Common Issues

-   **Port Already in Use**: Change the port in `application.properties` or stop the running process.
-   **Database Connection Failure**: Verify database credentials and network connection.

---

## Additional Information

-   **Logs**: Check logs in the `/logs` directory or console output.
-   **Tests**: Run tests with:

```bash
./mvnw test
```

If you encounter any issues not covered here, feel free to reach out to me.

---

**Happy Coding!**
