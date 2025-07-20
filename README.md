# 🚀 Microservices-Based Application with Kafka Integration

A **scalable, event-driven microservices architecture** built using modern Java technologies. This application demonstrates enterprise-grade patterns like asynchronous communication via **Apache Kafka**, service decoupling, persistence using **Spring Data JPA**, and relational storage in **MySQL**.

> 🧠 Built to showcase hands-on expertise in Java Full Stack development.

---

## 🧰 Tech Stack

| 🧩 Layer        | ⚙️ Technologies Used                                                                 |
|----------------|----------------------------------------------------------------------------------------|
| **Backend**     | Java 17 · Spring Boot 3 · Spring Web · Spring Validation · Spring JPA (Hibernate)     |
| **Database**    | MySQL · JPA/Hibernate                                                                 |
| **Messaging**   | Apache Kafka · Spring for Apache Kafka                                                |
| **Build Tool**  | Maven                                                                                 |
| **Dev Tools**   | Lombok · Spring DevTools · Postman · Kafka CLI                                        |
| **Security**    | 🔒 _Planned:_ Spring Security · JWT                                                    |
| **UI (Planned)**| 💻 React.js · Chakra UI · Axios                                                        |
| **Cloud & Infra**| ☁️ _Planned:_ Docker · AWS (EC2, S3) · GitHub Actions CI/CD                          |

---

## 🧱 Architecture Highlights

- 🧬 **Microservices Pattern** — Modular, loosely coupled services for scalability.
- 📩 **Apache Kafka** — Asynchronous communication via producer-consumer architecture.
- 🔧 **Spring Boot** — Auto-configured, production-ready Java microservices.
- 💾 **Spring Data JPA + MySQL** — Clean ORM-based persistence layer.
- 📦 **DTO + Events** — Clean separation between domain models and transport objects.
- 🔮 **Future Enhancements**:
  - 🐳 Docker-based deployments
  - 🔍 Service discovery with **Eureka**
  - 🌐 API Gateway via **Spring Cloud Gateway**
  - 🛡️ Circuit breaker with **Resilience4j**
  - 📊 Monitoring with **Prometheus + Grafana**

---

## 📦 Current Modules

| 🧩 Service Name     | 📄 Description                                                                 |
|---------------------|--------------------------------------------------------------------------------|
| `quiz-service`       | Handles quiz data, sends question requests to Kafka with correlation ID        |
| `question-service`   | Listens to Kafka, fetches questions, and publishes results back via Kafka      |

---

## 📨 Kafka Topics

| 🧵 Topic Name              | 🔍 Purpose                                            |
|----------------------------|------------------------------------------------------|
| `question-request-topic`   | 🔄 Requests for questions based on `quizId`          |
| `question-response-topic`  | 📤 Responds with a list of matching `Question` DTOs  |

---

## ✅ Features Implemented

- ✅ Kafka Producer/Consumer using `ConcurrentKafkaListenerContainerFactory`
- ✅ JSON serialization via `JsonSerializer` & `JsonDeserializer`
- ✅ CompletableFuture-based request-response with timeout fallback
- ✅ Cleanly structured DTO/event layer for Kafka transport
- ✅ Modular Maven-based structure with isolated services

---

## 🧠 Learning Objectives

This repository demonstrates:

- 💡 Deep knowledge of **Spring Boot** and Java microservices
- ⚙️ Use of **Kafka** for asynchronous, decoupled service interaction
- 🔄 Designing non-blocking APIs with **CompletableFuture**
- 🏗️ Layered architecture (Controller → Service → Repository)
- 🧪 Use of DTO/Event pattern to reduce entity leaks
- 📁 Modular Maven setup for large-scale project architecture

---

## 🛠️ To-Do / Upcoming Features

- [ ] 🔐 Implement `user-service` with authentication (JWT + Spring Security)
- [ ] 🌐 Add API Gateway using Spring Cloud Gateway
- [ ] 🐳 Dockerize all services for containerized deployment
- [ ] 📁 MongoDB integration for unstructured logs
- [ ] 🚨 Global exception handling with `@ControllerAdvice`
- [ ] 💻 UI Frontend with **React + Chakra UI**
- [ ] 🧪 Add unit and integration tests using **JUnit + TestContainers**
- [ ] ☁️ Deploy to **AWS** using GitHub Actions

---

## 📸 Screenshots / Demo

> Coming Soon!

---

## 🤝 Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you'd like to change.

---

## 📄 License

This project is licensed under the **MIT License**.

---

### 📌 _Perfect for demonstrating enterprise-grade backend and messaging capabilities in interviews and production environments._

---

