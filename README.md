# README: Microservice Conference Management Application

## Project Overview
This project is a microservice-based application designed to manage conferences hosted by keynote speakers. It includes the following features:

- Management of keynotes, including details such as ID, name, email, and role.
- Management of conferences, including ID, title, type (academic or commercial), date, duration, number of attendees, and ratings.
- Management of reviews for each conference with attributes like ID, date, text, and stars (1-5).

## Architecture

The application is built on a microservice architecture with the following components:

### Functional Microservices
1. **Keynote Service**: Handles all keynote-related operations.
2. **Conference Service**: Handles conference-related operations and includes review management.

### Technical Microservices
1. **Gateway Service**: A Spring Cloud Gateway for routing and load balancing.
2. **Discovery Service**: Implements service discovery using Consul Discovery.
3. **Configuration Service**: Centralized configuration management using Consul Config.

### Security
- Authentication and authorization are implemented using OAuth2 and OIDC with Keycloak as the identity provider.

### Frontend
- A web frontend built with Angular for user interaction.

### Fault Tolerance
- Resilience4J for circuit breaker implementation.

### API Documentation
- RESTful API documentation generated with OpenAPI (Swagger).

### Deployment
- Docker and Docker Compose for containerization and deployment.

## Getting Started

### Prerequisites

- Java 17
- Maven
- Docker and Docker Compose
- Node.js and Angular CLI
- Keycloak server setup



## Directory Structure
```
/microservice-conference-management
├── keynote-service
├── conference-service
├── gateway-service
├── discovery-service
├── config-service
├── angular-front-app
├── docker-compose.yml
└── README.md
```

## Features

### Keynote Service
- CRUD operations for keynote speakers.
- API endpoints documented with Swagger.

### Conference Service
- CRUD operations for conferences.
- Review management.
- OpenFeign client for inter-service communication.
- API endpoints documented with Swagger.

### Gateway Service
- Centralized routing for all microservices.
- Load balancing and request filtering.

### Discovery Service
- Service registry and discovery using Consul.

### Config Service
- Centralized configuration using Consul Config.

### Frontend
- Conference and keynote management interface built with Angular.

### Security
- Keycloak integration for secure authentication.




kc.bat start-dev
consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=192.168.0.192
admin 1234
http://localhost:8080/realms/sdia-realm
http://localhost:8080/realms
/sdia-realm/.well-known/openid-configuration

ng new secure-front-angular --no-standalone
npm install bootstrap  
npm i bootstrap bootstrap-icons    
ng g c conference
ng g c keynote
ng g guard guards/auth
npm install keycloak-js
npm install keycloak-angular
add to assets keycloak.json
ng generate service services/keycloak
ng generate interceptor interceptors/auth

