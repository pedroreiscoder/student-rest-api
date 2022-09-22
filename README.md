# student-rest-api
REST API developed using Java, Spring Boot, Spring Data JPA and PostgreSQL that allows a user to create, read, update and delete students

## Requirements
JDK 17  
PostgreSQL v14.4+

## Installation
After cloning the repository, open the project with your favorite IDE (Eclipse, IntelliJ IDEA, Netbeans, etc)

Go to the `application.properties` file and replace the connection information with the settings of your Postgres instance

## How to Use
`GET /api/students` Returns a list of students

**Response:**
```
[
    {
        "id": 1,
        "name": "Pedro",
        "email": "pedro@gmail.com",
        "age": 22
    },
    {
        "id": 2,
        "name": "Ricardo",
        "email": "ricardo@gmail.com",
        "age": 23
    }
]
```

`GET /api/students/{id}` Returns the student with the specified id

**Response:**
```
{
    "id": 1,
    "name": "Pedro",
    "email": "pedro@gmail.com",
    "age": 22
}
```

`POST /api/students` Creates a new student and returns the created student

**Request body:**
```
{
    "name": "Felipe",
    "email": "felipe@gmail.com",
    "age": 19
}
```

**Response:**
```
{
    "id": 3,
    "name": "Felipe",
    "email": "felipe@gmail.com",
    "age": 19
}
```

`PUT /api/students/{id}` Updates the student with the specified id and returns the updated student

**Request body:**
```
{
    "name": "Joaquim",
    "email": "joaquim@gmail.com",
    "age": 36
}
```

**Response:**
```
{
    "id": 3,
    "name": "Joaquim",
    "email": "joaquim@gmail.com",
    "age": 36
}
```

`DELETE /api/students/{id}` Deletes the student with the specified id

**Response:**
```
204 No Content
```
