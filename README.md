# mini-linkedin-backend (Spring Boot)

Backend REST API for Mini-LinkedIn social media app built using **Spring Boot**, **Spring Security**, **JPA/Hibernate**, and **MySQL**.

---

## Technologies Used

- Spring Boot 3.x
- Spring Security + JWT authentication
- Spring Data JPA
- MySQL
- Lombok

---

## Features Implemented

- User registration and login (JWT based authentication)
- Create Post (only for authenticated user)
- View all posts
- View posts created by current logged-in user
- View posts created by any specific user
- Fetch user’s profile details

---

## Local Setup

### 1. Clone and import

```bash
git clone https://github.com/<username>/mini-linkedin-backend.git
cd mini-linkedin-backend

2. Configure Database
Create database in MySQL:

CREATE DATABASE mini_linkedin;

Update the following in src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/mini_linkedin
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

3. Run the application

./mvn spring-boot:run (or) Navigate to mini-linkedin-backend/src/main/java/com/.../MiniLinkedinBackendApplication.java,
right-click the class → Run as ➝ Java Application
Application will start on http://localhost:8080

APIs & Sample Requests
Note: All POST APIs require Authorization: Bearer <token> header after login.

1. Register User

POST /users/register
Request:

{
  "name": "Lakshmi",
  "email": "lakshmi@gmail.com",
  "password": "12345"
}
2. Login
POST /users/login

Request:
{
  "email": "lakshmi@gmail.com",
  "password": "12345"
}
Response:
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
Use this token for other requests in Authorization header.

3. Create Post

POST /posts
Headers → Authorization: Bearer <token>

{
  "title": "Hello World",
  "description": "My first post"
}
4. Get All Posts
GET /posts

5. Get Current Logged-in User Posts

GET /posts/my
Headers → Authorization: Bearer <token>

6. Get Posts of Any User

GET /posts/user/{userId}
Example → /posts/user/2

7. Get User Profile by ID
GET /{id}
Example → /3

Directory Structure (important packages)

com.ciaancybertech.mini_linkedin_services
│
├── controllers
│     ├── AuthController.java
│     ├── PostController.java
│     └── ProfileController.java
│
├── entities
│     ├── User.java
│     └── Post.java
│
├── repos
│     ├── UserRepository.java
│     └── PostRepository.java
│
└── security
      ├── JwtAuthFilter.java
      ├── SecurityConfig.java
      └── JwtUtil.java

Running with Postman

Register → /users/register
Login → Copy JWT token from response
Set header → Authorization: Bearer <copied-token>
Access /posts, /posts/my, /posts/user/{id}, /posts with the corresponding request structure mentioned above.

# Future Enhancements
Post delete/edit
Add comments and likes
Follow / unfollow user
Newsfeed sorting (by time / relevance)

