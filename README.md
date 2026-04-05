# 🛒 E-Commerce Store (Spring Boot) - Backend

## 🚀 Tech Stack

* Java
* Spring Boot
* Spring Security (JWT)
* PostgreSQL
* Docker

---

## ✨ Features

* User Signup & Signin
* JWT Authentication
* Product APIs with Pagination
* Secure REST APIs
* Layered Architecture

---

## 🐳 Run Database using Docker

```bash
docker run -d --name ecommerce-postgres \
-e POSTGRES_DB=ecommerce \
-e POSTGRES_USER=postgres \
-e POSTGRES_PASSWORD=postgres \
-p 5432:5432 \
-v postgres_data:/var/lib/postgresql/data postgres
```

---

## ⚙️ Application Setup

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
```

---

## 🔐 Authentication Flow

### Signup

POST /auth/signup

### Signin

POST /auth/signin

---

## 🔑 Use JWT Token

```
Authorization: Bearer <token>
```

---

## 📡 Example API

```
GET /api/products?pageNumber=0&pageSize=10
Get /api/products/
```
---

## 🧠 Project Highlights

* Custom JWT Authentication
* Secure API using Spring Security
* Dockerized Database
* Production-ready backend structure

---

## 💼 Resume Line

Built a secure E-Commerce backend using Spring Boot, Spring Security, JWT authentication, PostgreSQL, and Docker with REST APIs, pagination, and scalable architecture.
