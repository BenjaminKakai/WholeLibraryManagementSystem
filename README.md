**Library Management System**

This is a comprehensive microservices-based Library Management System built with Spring Boot, Apache Kafka, and modern cloud-native technologies. Through a distributed architecture, the system enables efficient management of book loans, reservations, and library operations.

**Key Features**

Microservices architecture with service discovery
Real-time messaging using Apache Kafka
Centralized configuration management
User authentication and authorization
External catalog integration
Book management and cataloging
PostgreSQL database integration

**System Architecture**

The system consists of the following microservices:

**API Gateway:** Entry point for external clients
**Config Server:** Centralized configuration management
**Eureka Service:** Service discovery and registration
**Catalog Management Service:** Book catalog operations
**User Management Service:** User authentication and management
**External Catalog Integration Service:** Integration with external book catalogs


**Getting Started**

**Prerequisites**

Java (JDK 11 or higher)
Apache Kafka (version 3.4.0)
PostgreSQL (version 12 or higher)
Maven

**Setting Up Kafka**

**1. Start Zookeeper:**

   /path/to/kafka/bin/zookeeper-server-start.sh /path/to/kafka/config/zookeeper.properties

**2. Start Kafka Server:**

  /path/to/kafka/bin/kafka-server-start.sh /path/to/kafka/config/server.properties


**Database Setup**
**1. Create PostgreSQL database and user:**

   CREATE DATABASE lmsbackend;
   CREATE USER lmsuser WITH PASSWORD 'securepassword';
   GRANT ALL PRIVILEGES ON DATABASE lmsbackend TO lmsuser;
   
**2. Configure database properties in application.properties:**

   spring.datasource.url=jdbc:postgresql://localhost:5432/lmsbackend
   spring.datasource.username=lmsuser
   spring.datasource.password=securepassword
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

**Running the Services**

**Start services in the following order:**
**1. Config Server:**
   cd config-server
   ./mvnw spring-boot:run

**2. Eureka Service (available at http://localhost:8761):**

   cd lmseureka
   ./mvnw spring-boot:run

**3. Other Services:**
   # Run for each service directory
   ./mvnw spring-boot:run


**API Endpoints**

**User Management**

**Register User**

POST /api/auth/signup
Content-Type: application/json

{
  "email": "user@example.com",
  "password": "password123",
  "role": ["user", "admin"]
}


**Login**

POST /api/auth/signin
Content-Type: application/json

{
  "username": "user@example.com",
  "password": "password123"
}


**Catalog Management**

**Add Book**

POST /api/books
Content-Type: application/json

{
  "title": "Book Title",
  "author": "Author Name",
  "isbn": "1234567890",
  "genre": "Fiction",
  "price": 19.99
}


**Get Book by ID**

GET /api/books/{id}

**Get All Books**

GET /api/books


**External Catalog Integration**

**Get Book Details by ISBN**

GET /api/external-catalog/book?isbn=1234567890


**Configuration**

**Eureka Client Configuration**

eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/


**Kafka Configuration**

spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=group_id
spring.kafka.consumer.auto-offset-reset=earliest


**Development**

**Building Services**

./mvnw clean package


**Running JAR files**

java -jar target/service-name-0.0.1-SNAPSHOT.jar


**Security**

JWT-based authentication
Role-based access control (USER, MODERATOR, ADMIN)
Secure password storage with encryption
Protected API endpoints


**Service Ports**

Config Server: 8082
Eureka Server: 8761
API Gateway: 8080
User Management: 8081
Catalog Management: 8083
External Catalog Integration: 8084







































