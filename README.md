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

Create a new databse in pgAdmin (PostgrSQL):
Name the database "workoutdb"

<br /> 

Update application.properties or application.yml with your PostgreSQL credentials:
```sh
spring.datasource.url=jdbc:postgresql://localhost:5432/restapi
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=create /// can be changed to update after the first time
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
  "username": "A username",
  "type": "run",
  "title": "A title",
  "description": "A description",
  "duration": "100",
  "calories": "1"
}
```
Response:
```sh
    {
        "id": 2,
        "username": "A username",
        "type": "run",
        "title": "A title",
        "description": "A description",
        "duration": 100,
        "calories": 1,
        "timestamp": "2025-03-17 18:48:20"
    }
```

**Get all Activities**
```sh 
GET /activities
```

Response:
```sh
[
    {
        "id": 2,
        "username": "A username",
        "type": "run",
        "title": "A title",
        "description": "A description",
        "duration": 100,
        "calories": 1,
        "timestamp": "2025-03-17 18:48:20"
    },
    {
        "id": 3,
        "username": "Another username",
        "type": "workout",
        "title": "Another title",
        "description": "Another description",
        "duration": 110,
        "calories": 2,
        "timestamp": "2025-03-17 18:50:04"
    }
]
```

**Get a specific Activity**
```sh 
GET /activities/id
```
Response:
```sh
    {
        "id": 2,
        "username": "A username",
        "type": "run",
        "title": "A title",
        "description": "A description",
        "duration": 100,
        "calories": 1,
        "timestamp": "2025-03-17 18:48:20"
    }
```

**Delete Activity**
```sh
DELETE /activities/id
```

Response:
```sh
200 OK
```

**Update Activity**
```sh
PUT /activities/id
```

Request body:
```sh
    {
        "type": "workout",
        "title": "Updated title",
        "description": "Updated description",
        "duration": 110
    }
```

Response:
```sh
    {
        "id": 3,
        "username": "Another username",
        "type": "workout",
        "title": "Updated title",
        "description": "Updated description",
        "duration": 110,
        "calories": 2,
        "timestamp": "2025-03-17 18:50:04"
    }
```
