# Movie Management REST API

A simple RESTful API for managing movies, built with Spring Boot.

## Table of Contents
- [Overview](#overview)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
- [Running the Application](#running-the-application)
- [Testing the API](#testing-the-api)

## Overview

This project demonstrates a simple CRUD (Create, Read, Update, Delete) REST API for managing a movie collection. It's designed as a learning project to understand:

- Spring Boot basics
- REST API design
- Layered architecture (Controller → Service → Repository)
- Input validation
- Exception handling

## Technology Stack

| Technology | Purpose |
|------------|---------|
| Java 17 | Programming language |
| Spring Boot 3.2 | Application framework |
| Maven | Build tool & dependency management |
| Spring Web | REST API support |
| Spring Validation | Input validation |

## 📁 Project Structure
movie-api/
├── src/main/java/com/demo/
│ ├── MovieApiApplication.java # Main entry point
│ ├── model/
│ │ └── Movie.java # Data model
│ ├── repository/
│ │ └── MovieRepository.java # Data storage (ArrayList)
│ ├── service/
│ │ └── MovieService.java # Business logic
│ ├── controller/
│ │ └── MovieController.java # API endpoints
│ └── exception/
│ ├── MovieNotFoundException.java
│ └── GlobalExceptionHandler.java
├── src/main/resources/
│ └── application.properties # Configuration
├── pom.xml # Dependencies


## API Endpoints

### Base URL: `http://localhost:8080/api/movies`

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/movies` | Get all movies |
| GET | `/api/movies/{id}` | Get movie by ID |
| POST | `/api/movies` | Create new movie |
| GET | `/api/movies/genre/{genre}` | Get movies by genre |
| GET | `/api/movies/count` | Get movie count |

### Request/Response Examples

#### Get All Movies
GET /api/movies
[
  {
    "id": 1,
    "title": "Inception",
    "description": "A thief who enters dreams...",
    "genre": "Sci-Fi",
    "releaseYear": 2010,
    "rating": 8.8,
    "director": "Christopher Nolan",
    "durationMinutes": 148
  }
]

###Create a Movie

POST /api/movies
Content-Type: application/json

{
  "title": "The Matrix",
  "description": "A computer hacker learns about reality",
  "genre": "Sci-Fi",
  "releaseYear": 1999,
  "rating": 8.7,
  "director": "The Wachowskis",
  "durationMinutes": 136
}

#Running the Application
##Prerequisites
Java 17 or higher
Maven 3.6+
##Steps
Clone/Download the project

Navigate to project directory
cd movie-api

Build the project
mvn clean install

Run the application
mvn spring-boot:run

Application will start at:
http://localhost:5000
