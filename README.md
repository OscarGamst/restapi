# Workout App Backend


## Overview
A **Spring Boot** backend for a workout tracking application. This backend handles user activities, stores data in a **PostgreSQL** database, and provides **REST APIs** for managing activities.

## Features
- Activity tracking (running, workouts, etc.)
- User authentication and authorization *(future implementation)*
- REST API for activity management
- PostgreSQL database integration
- DTO-based request/response handling (Will be expanded with mappers)
- Service-layer business logic
- Structured project architecture
- API documentation with Postman (Swagger will be implemented in the future)

## Technologies Used
| Technology   | Version |
|-------------|-----------|
| Java        | minumim 22|
| Spring Boot | 2.7       |
| PostgreSQL  | 14        |
| MapStruct   | Latest    |
| Lombok      | Latest    |
| Docker      | Planned   |

## Setup Instructions
### Prerequisites
- Install **Java 22**
- Install **PostgreSQL** and create a database
- Install **Maven**
- IDE (this project made with intelliJ IDEA)

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

# API Documentation
Base URL
```sh
http://localhost:8080/api/
```

For this project I have chosen to do testing and documentation with Postman, 
but for ease I will add Swagger UI to make it easier for others to test the API.
To test and access:
- Swagger UI: http://localhost:8080/swagger-ui.html
- OpenAPI JSON: http://localhost:8080/v3/api-docs


here is the structure of the project:

```sh
src/main/java/com/example/restapi/
├── config/          # Configuration classes
├── controller/      # REST controllers
├── model/          # Entity classes
├── repository/     # Data access layer
├── service/        # Business logic
├── dto/            # Data Transfer Objects
├── mapper/         # Object mappers
└── exception/      # Exception handling
```
## Key Features
### Users
- Create and update users
- Deleting users 
- See users Activities 

### Activities
- Create activities
- update activities (will be added)
- Deleting activities (will be added as a standalone, only works when deleting user)
- Viewing activities (and filter different types, only basic now) 

## Users
### Endpoints
**Create User**
```sh
POST /users
```

Request Body:
```sh
{
  "username": "A username",
  "email": "email@example.com",
  "password": "password",
  "birthdate": "2000-01-01",
  "profileVis": true
}
```

**Get Users**
You can swap between /basic and /detailed, they have same functionality but show sligtly different data
```sh
GET /users/basic OR /detailed
```

Response:
```sh
[
    {
        "username": "A username",
        "email": "email@example.com",
        "profile_vis": true
    },
    {
        "username": "Another username",
        "email": "email@example.com",
        "profile_vis": false
    }
]
```

```sh
GET /users/detailed/{username}  OR /basic
```
Response:
```sh
{
    "username": "A username",
    "password": "password",
    "email": "email@example.com",
    "birthday": null,
    "profile_vis": true
}
```
**Delete User**
```sh
DEL /users/delete{username}
```
This will delete the user and all their related activities

## Activities
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
  "calories": "1",
  "distance": "5"
}
//Another example
{
  "username": "Another username",
  "type": "workout",
  "title": "A title",
  "description": "A description",
  "duration": "99",
  "calories": "10",
  "sets": "1",
  "reps": "3",
  "weight": "5"
}
```

**Get Activity**
```sh 
GET /activity/{id}
```
For now it still shows the other fields, but will try to make it more smooth,
and I will add so you can get all activites etc.
Response:
```sh
{
    "id": 3,
    "type": "activityrun",
    "title": "A title",
    "description": "A description",
    "duration": 100,
    "calories": 1,
    "timestamp": "2025-05-12T19:31:12.695184",
    "username": "A username",
    "distance": 5,
    "sets": null,
    "reps": null,
    "weight": null,
    "test": null
}
//Another example
{
    "id": 4,
    "type": "activityworkout",
    "title": "A title",
    "description": "A description",
    "duration": 99,
    "calories": 10,
    "timestamp": "2025-05-12T19:32:47.937357",
    "username": "Another username",
    "distance": null,
    "sets": 1,
    "reps": 3,
    "weight": 5,
    "test": null
}
```
