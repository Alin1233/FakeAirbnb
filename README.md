# Fake Airbnb

## Description

Fake Airbnb is a RESTful API that emulates core functionalities of the Airbnb platform. It allows users to manage bookings, cities, roles, and user profiles. Built with Spring Boot, the application utilizes Gradle for project management, Flyway for database migrations, and PostgreSQL for data storage.

## Technologies

- **Spring Boot**: Framework for building Java-based web applications.
- **Gradle**: Build automation tool used for project dependency management.
- **Flyway**: Version control tool for database migrations.
- **PostgreSQL**: Relational database management system.

## Setup and Launch

### Prerequisites

- **Java Development Kit (JDK)**: Ensure JDK 17 or higher is installed.
- **Gradle**: Install Gradle on your system.
- **PostgreSQL**: Set up a PostgreSQL database instance.

### Configuration

1. **Database Setup**:
   - Create a PostgreSQL database named `fake_airbnb`.
   - Configure the database connection settings in the `application.properties` or `application.yml` file:

     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/fake_airbnb
     spring.datasource.username=your_db_username
     spring.datasource.password=your_db_password
     ```

2. **Flyway Migration**:
   - Place your migration scripts in the `src/main/resources/db/migration` directory.
   - Flyway will automatically execute these scripts upon application startup to set up the database schema.

### Running the Application

Navigate to the project's root directory and execute the following command to build and run the application:

```bash
./gradlew bootRun
```

The application will start and be accessible at `http://localhost:8080`.

## Sample API Requests

### Create a Booking

**POST** `http://localhost:8080/api/bookings`

**Request Body**:

```json
{
  "title": "beach ",
  "arrivalDate": "2025-05-16",
  "checkoutDate": "2025-05-22",
  "price": 699.99,
  "cityId": 1,
  "userId": "1"
}
```

**Response**:

```json
{
  "id": "generated-booking-id",
  "title": "beach ",
  "arrivalDate": "2025-05-16",
  "checkoutDate": "2025-05-22",
  "price": 699.99,
  "city": {
    "id": 1,
    "name": "Miami Beach"
  },
  "user": {
    "id": "1",
    "firstname": "John",
    "lastname": "Doe",
    "phone": "+1-555-123-4567"
  }
}
```

### Retrieve Bookings with Filters

**GET** `http://localhost:8080/api/bookings?page=0&size=20&sortBy=price&direction=desc&titleContains=b&minPrice=100`

**Response**:

```json
{
  "content": [
    {
      "id": "c3965a32-6cf9-4286-bb66-5e7b7dbca89a",
      "title": "beach ",
      "arrivalDate": "2025-05-16",
      "checkoutDate": "2025-05-22",
      "price": 699.99,
      "city": {
        "id": 1,
        "name": "Miami Beach"
      },
      "user": {
        "id": "1",
        "firstname": "John",
        "lastname": "Doe",
        "phone": "+1-555-123-4567"
      }
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 20,
    "sort": {
      "sorted": true,
      "unsorted": false,
      "empty": false
    },
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "totalPages": 1,
  "totalElements": 1,
  "last": true,
  "first": true,
  "size": 20,
  "number": 0,
  "sort": {
    "sorted": true,
    "unsorted": false,
    "empty": false
  },
  "numberOfElements": 1,
  "empty": false
}
```

## Entities

The application manages the following entities:

- **User**: Represents a user profile with personal details.
- **Booking**: Contains booking information including dates, price, and associations to a user and a city.
- **Role**: Defines user roles within the system.
- **City**: Represents a city where properties are located.

## Notes

- Ensure that the PostgreSQL database is running before starting the application.

---

This README provides an overview of the Fake Airbnb project, including setup instructions, technologies used, and sample API requests. For further details, refer to the project documentation or source code. 
