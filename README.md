#  Personal Blog Backend — Spring Boot

A backend system for a personal blogging platform, designed with clean architecture, RESTful APIs, and real-world backend best practices.

---

##  Project Overview

This project is a **backend-only blog application** built using Spring Boot.

It focuses on:
- Clear separation of concerns
- Optimized API responses using DTOs
- Read vs write API segregation
- Production-inspired design decisions

**Admin capabilities**
- Create, update, delete blog posts

**User capabilities**
- View blog summaries
- Read full blog content

---

##  System Architecture

> High-level architecture of the application

![Architecture Diagram](./images/architecture.png)

**Architecture highlights**
- Layered architecture (Controller → Service → Repository)
- DTO-based API responses
- Database access via JPA/Hibernate
- Security layer protecting write operations

---

##  Data Flow

> End-to-end request flow for read and write operations

![Data Flow Diagram](./images/data-flow.png)

**Flow summary**
1. Client sends HTTP request
2. Controller handles routing
3. Service layer applies business logic
4. Repository interacts with PostgreSQL
5. Optimized response returned via DTO/entity

---

##  API Design

| Endpoint | Method | Description |
|--------|--------|------------|
| `/blog` | GET | Fetch all blog summaries |
| `/blog/{id}` | GET | Fetch full blog content |
| `/blog` | POST | Create a new blog |
| `/blog/{id}` | PUT | Update an existing blog |
| `/blog/{id}` | DELETE | Delete a blog |

**Design principles**
- Summary vs detail endpoints
- Reduced payload size
- REST-compliant HTTP methods
- PATCH planned for future enhancements

---

##  Domain Model

### Blog Entity
- `UUID id`
- `title`
- `description`
- `content (TEXT)`
- `Mood (enum)`
- `createdAt`

**Key decisions**
- UUID for non-predictable IDs
- Separate preview and full content fields
- Enum-based mood classification

---

##  Repository & DTO Strategy

- Repository extends `JpaRepository<BlogEntity, UUID>`
- Custom JPQL queries return `BlogSummaryDTO`

**Why DTOs**
- Prevent internal model exposure
- Improve performance
- Enable multiple response shapes
- Enhance API security

---

##  Service Layer

The service layer acts as the **single source of business logic**.

**Responsibilities**
- Blog creation, updates, deletion
- Fetching summaries and full content
- Handling invalid or missing blog IDs

This keeps controllers thin and improves maintainability.

---

##  Controller Design

**Read Controller**
- Handles all GET requests
- Read-only operations
- CORS enabled for frontend access

**Write Controller**
- Handles POST, PUT, DELETE
- Secured endpoints
- Designed for future role-based access

---

##  Security

- Spring Security integrated
- Write operations restricted
- Basic session-based authentication

> Security is currently learning-oriented and extensible for future role-based authorization.

---

##  Error Handling

- Fail-fast approach using `orElseThrow`
- Business validation handled in service layer
- Designed for future global exception handling

---

##  API Testing

- All endpoints tested using Postman
- Validated request/response contracts
- Tested edge cases (invalid UUIDs, missing data)

---

##  Technical Challenges

**JPA + UUID runtime mismatches**
- Compiled successfully but failed at runtime
- Highlighted importance of precise repository signatures
- Improved debugging and testing discipline

---

##  Tech Stack

- Spring Boot
- Spring Web
- Spring Data JPA (Hibernate)
- PostgreSQL
- Spring Security
- Lombok
- Maven
- Postman

---

##  Key Learnings

- Importance of layered architecture
- Why DTOs matter in real APIs
- Handling runtime ORM issues
- Designing APIs for performance and safety
- Refactoring as complexity grows

---

##  Future Enhancements

- PATCH support for partial updates
- Role-based authorization
- Global exception handling
- API documentation (Swagger/OpenAPI)

---

##  Notes

This project reflects **real backend development**, not textbook examples.  
It is actively evolving and was built to deepen understanding of Spring Boot, JPA, and API design.
