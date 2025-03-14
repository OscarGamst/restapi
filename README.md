# Workout App Backend


## Overview
A **Spring Boot** backend for a workout tracking application. This backend handles user activities, stores data in a **PostgreSQL** database, and provides **REST APIs** for managing activities.

## Features
- Activity tracking (running, workouts, etc.)
- User authentication and authorization *(future implementation)*
- REST API for activity management
- PostgreSQL database integration
- DTO-based request/response handling
- Service-layer business logic
- Structured project architecture
- API documentation with Postman

## Technologies Used
| Technology   | Version |
|-------------|---------|
| Java        | 17      |
| Spring Boot | 2.7     |
| PostgreSQL  | 14      |
| MapStruct   | Latest  |
| Lombok      | Latest  |
| Docker      | Planned |

## Setup Instructions
### Prerequisites
- Install **Java 17**
- Install **PostgreSQL** and create a database
- Install **Maven**

### Clone the Repository
```sh
git clone <repository-url>
cd restapi
```

### Configure the Database

Update application.properties or application.yml with your PostgreSQL credentials:
```sh
spring.datasource.url=jdbc:postgresql://localhost:5432/restapi
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update /// OR create
```
Build and Run the Application
```sh
mvn clean install
mvn spring-boot:run
```

## API Documentation
Base URL
```sh
http://localhost:8080/api/
```

### Endpoints
**Add activity**
```sh 
POST /activities
```

Request Body:
```sh
{
  "type": "run",
  "distance": 5.0,
  "duration": 1800,
  "date": "2025-03-10"
}
```
response:
```sh
{
  "id": 1,
  "type": "RUNNING",
  "distance": 5.0,
  "duration": 1800,
  "date": "2025-03-10"
}
```

Get All Activities:
```sh
[
  {
    "id": 1,
    "type": "run",
    "distance": 5.0,
    "duration": 1800,
    "date": "2025-03-10"
  },
  {
    "id": 2,
    "type": "workout",
    "distance": 5.0,
    "duration": 1800,
    "date": "2025-03-10"
  }

]
```
