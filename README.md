# 1_HB_4 - Class Schedule Management System

## Project Overview
This project is a comprehensive class schedule management system that allows users to manage classes, instructors, schedules, and reviews. The system consists of a Java-based backend API and an Android mobile application frontend.

## Repository Structure

### Backend
The Backend directory contains a Java-based web application built with Spring Boot. It provides RESTful APIs for managing:
- Classes and course information
- Instructors and their details
- User accounts and authentication
- Class schedules
- Reviews and ratings
- Real-time communication via WebSockets

The backend follows a standard Maven project structure with source code in the `src/main/java/backend` directory. It utilizes a relational database for efficient data storage and retrieval of all application information.

### Frontend
The Frontend directory contains an Android mobile application built with Gradle. The application provides:
- User login and authentication
- Class listing and details
- Schedule management
- User interface for all backend functionality

The frontend is organized as a standard Android project with Gradle as the build system.

### Documents
The Documents directory contains project documentation, including:
- Backend API documentation (Javadocs)
- Frontend code documentation
- Test coverage reports
- Project reports and specifications

### Experiments
The Experiments directory contains prototype code and experimental features developed by team members before integration into the main project. It includes:
- Individual team member experiments
- Technology explorations
- Prototype implementations

## Documentation Links
- [Frontend Javadocs](http://coms-309-032.class.las.iastate.edu/Frontend_Docs/)  
- [Backend Javadocs](http://coms-309-032.class.las.iastate.edu/javadoc-backend/)  
- [API Reference](https://app.swaggerhub.com/apis/enicely/backend-api/1.0.0)  

## Setup Instructions

### Backend Setup
1. Navigate to the Backend directory
2. Run `./mvnw spring-boot:run` (on Windows: `mvnw.cmd spring-boot:run`)
3. The backend server will start on the default port (usually 8080)

### Frontend Setup
1. Navigate to the Frontend/FrontendApplication directory
2. Open the project in Android Studio
3. Build and run the application on an Android device or emulator

## Development

### Backend Development
- The backend is built with Spring Boot
- API endpoints are documented in the Swagger API Reference
- Test coverage reports are available in the Documents/backend_coverage_report directory

### Frontend Development
- The frontend is an Android application
- Documentation is available in the Frontend_Docs directory

## Contributors
- Team 1_HB_4
  - Max B
  - Sam R
  - Evan N
