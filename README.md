🚀 Microservices-Based Application with Kafka Integration
A scalable, event-driven microservices architecture built using modern Java technologies. This project demonstrates enterprise-grade patterns like asynchronous communication via Apache Kafka, service decoupling, and persistence using JPA with MySQL. The system is designed to evolve with more features and services in a modular, maintainable way.

🧰 Tech Stack
Layer	Technologies Used
Backend	Java 17, Spring Boot 3, Spring Web, Spring JPA, Spring Validation
Database	MySQL (Relational DB), Hibernate (JPA implementation)
Messaging	Apache Kafka, Spring for Apache Kafka
Build & Config	Maven, Spring Profiles, application.yml
Dev Tools	Lombok, DevTools, Postman (API testing), Kafka CLI tools
Security	To be integrated: Spring Security, JWT
UI (Planned)	To be integrated: React, Chakra UI, Axios
Cloud & Infra	To be integrated: Docker, AWS (S3 / EC2), CI/CD with GitHub Actions

🧱 Architecture
Microservices Pattern: Each service is independently deployable and communicates via Kafka topics.

Apache Kafka: Used for asynchronous communication between services (producer-consumer model).

Spring Boot: Rapid backend development with auto-configuration and production-ready defaults.

JPA & MySQL: ORM-based data layer for relational data storage.

DTOs & Event Classes: Clean separation of internal entities vs. event payloads.

Future Integrations:

Dockerized services

Service discovery (e.g. Eureka)

API Gateway (e.g. Spring Cloud Gateway)

Circuit breaker pattern (e.g. Resilience4j)

Monitoring with Prometheus + Grafana

📦 Current Modules
quiz-service
Handles quiz-related operations. Sends Kafka requests to retrieve associated questions.

question-service
Consumes messages from quiz-service, processes them, and responds on a Kafka topic with data.

📨 Kafka Topics
Topic Name	Purpose
question-request-topic	Requests for fetching questions by quiz ID
question-response-topic	Response payload containing questions

✅ Features Implemented
 Kafka producer and consumer configuration using ConcurrentKafkaListenerContainerFactory

 JSON serialization with JsonSerializer / JsonDeserializer

 CompletableFuture-based request/response handling for async Kafka workflows

 Clean error handling and timeouts

 Decoupled services using DTOs and events

🧠 Learning Objectives
This project showcases:

Deep understanding of Java + Spring Boot ecosystem

Implementing asynchronous communication via Kafka

Building scalable microservices with clean separation

Using CompletableFutures for non-blocking responses

Using real-world production practices (DTO, Layered Architecture, Maven module structure)

🛠️ To-Do / Upcoming Work
 Add user-service and implement authentication (JWT)

 API Gateway + Load Balancer

 Dockerize all services

 Integrate MongoDB for unstructured logging

 Add global exception handling using @ControllerAdvice

 UI frontend in React + Chakra UI

 Unit and Integration testing using JUnit + TestContainers

 Deployment on AWS

📷 Screenshots / Demo (Coming Soon)
🤝 Contributing
Pull requests are welcome! For major changes, please open an issue first.

📄 License
This project is under the MIT License.
