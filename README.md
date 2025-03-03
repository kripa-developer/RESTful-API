# RESTful-API
A Spring Boot-based RESTful API for managing student data with CRUD operations.

## 🚀 Features
* Create, Read, Update, and Delete (CRUD) operations for students.
* Uses **Spring Boot**, **Spring Data JPA**, and **Hibernate**.
* Supports **H2 / MySQL** database.
* JSON-based API responses.
  
## 📦 Technologies Used
* Java 17 / 21
* Spring Boot
* Spring Data JPA
* Hibernate
* H2 / MySQL Database
* Maven
* Postman (for API testing)

## 📂 Project Structure
```
RESTful-API/
│── src/
│   ├── main/java/com/example/student/
│   │   ├── controller/   # REST API Controllers
│   │   ├── service/      # Business logic layer
│   │   ├── repository/   # JPA repositories
│   │   ├── model/        # Entity models
│   │   ├── exception/    # Custom exceptions
│   ├── main/resources/
│   │   ├── application.yml  # Application configurations
│── pom.xml   # Maven dependencies
│── README.md # Project documentation
```
## 🛠 Setup & Installation

1.  Clone the Repository
   ```
git clone git@github.com:kripa-developer/RESTful-API.git
cd RESTful-API

```
2. Configure the Database (H2 or MySQL)
   Modify application.properties or application.yml:
   ```
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

   ```
   For MySQL, update:properties
```
   spring.datasource.url=jdbc:mysql://localhost:3306/restful_api
   spring.datasource.username=root
   spring.datasource.password=root
   spring.jpa.hibernate.ddl-auto=update
```
3.  Build & Run the Application
   ```
   mvn clean install
   mvn spring-boot:run

```
4. API Endpoints

| HTTP Method | Endpoint | Description |
|------------|----------|-------------|
| `POST`     | `/student/create`       | Create a new student |
| `GET`      | `/student/getStudent/{studentId}` | Retrieve student details |
| `PUT`      | `/student/update`  | Update student details |
| `DELETE`   | `/student/delete/{studentId}`  | Delete student |

5. Test with Postman or cURL   
    Example: Create a Student
```
curl -X POST http://localhost:8080/student/create \
-H "Content-Type: application/json" \
-d '{"studentId": "121", "name": "SALAN", "age": 12, "address": "ABCD", "phoneNumber": "324234", "grade": "A"}'

```

