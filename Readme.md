# AI Interview Question Generator – Backend

This is the backend service for the **AI Interview Question Generator** application.  
It is built using **Spring Boot** and integrates with **Google Gemini AI** to generate interview questions based on a given topic.

The generated questions are stored in a database so users can view their practice history.

----------------------------------------------------

## Features

- Generate AI-powered interview questions
- Store generated questions in database
- Retrieve previously generated question history
- RESTful API architecture
- Integration with Google Gemini AI
- Persistent database storage

----------------------------------------------------

## Tech Stack

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Google Gemini AI API
- Maven

----------------------------------------------------

## Project Architecture

Controller  
↓  
Service  
↓  
Repository  
↓  
Entity  
↓  
Database  

----------------------------------------------------

## Package Structure

com.prasad.ai_interview_generator

controller  
service  
repository  
model  
config  

----------------------------------------------------

## API Endpoints

### Generate Interview Questions

GET /api/generate?topic=Java

Example Response

[
  {
    "id": 1,
    "topic": "Java",
    "question": "What is polymorphism?"
  },
  {
    "id": 2,
    "topic": "Java",
    "question": "What is encapsulation?"
  }
]

----------------------------------------------------

### Get Question History

GET /api/history

Returns all previously generated questions stored in the database.

----------------------------------------------------

## Running the Backend

Clone the repository

git clone https://github.com/YOUR_USERNAME/backend-repo.git

Navigate to project

cd backend-repo

Run the application

    -mvn spring-boot:run

Backend runs at

http://localhost:8080

----------------------------------------------------

## Database

The project uses **H2 Database**.

Example configuration:

spring.datasource.url=jdbc:h2:file:./data/interviewdb  
spring.jpa.hibernate.ddl-auto=update  

Database file will be created inside the project folder.

----------------------------------------------------

## Future Improvements

- User authentication
- Topic filtering
- Cloud deployment
- Integration with MySQL/PostgreSQL
- Question difficulty levels

----------------------------------------------------

## Author

Devi Naga Prasad  
BTech – Mallareddy University