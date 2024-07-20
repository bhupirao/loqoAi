# Loqoai Assignment Project

This is a project for a Spring Boot application that manages products using a MySQL database. It includes a RESTful API for filtering and sorting product records based on specified parameters.

## Prerequisites

- Java 17
- Maven
- MySQL

## Getting Started

1. **Clone the repository:**
    ```sh
    git clone https://github.com/your-repo/loqoai-demo.git
    cd loqoai-demo
    ```

2. **Configure the database:**
   Create a MySQL database and update the `application.properties` file with your database details:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your-database
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

3. **Build the application:**
    ```sh
    mvn clean install
    ```

4. **Run the application:**
    ```sh
    mvn spring-boot:run
    ```


This will start the Spring Boot application and make the RESTful API available at http://localhost:8080.
Run Tests
To run the unit tests, use the following command:
mvn test
This will execute all the unit tests in the src/test/java directory and provide a test report in the console.

## Project Structure
src
├── main
│   ├── java
│   │   └── com
│   │       └── loqoai
│   │           ├── Model
│   │           │   └── Product.java
│   │           ├── Repository
│   │           │   └── ProductRepo.java
│   │           └── Service
│   │               └── ProductService.java
│   └── resources
│       └── application.properties
└── test
    └── java
        └── com
            └── loqoai
                └── Service
                    └── ProductServiceTest.java


## API Endpoints

### Add a Product

**Request:**
```http
POST /products
Content-Type: application/json

{
  "name": "Product1",
  "category": "Category1",
  "price": 10.0,
  "inStock": true,
  "rating": 4.5
}
### Get Product
Get Products with Filtering and Sorting
Request:
GET /products?category=electronics&minPrice=100&maxPrice=1000&inStock=true&sortField=price&sortOrder=asc

Response:
HTTP/1.1 200 OK
Content-Type: application/json

[
  {
    "id": 1,
    "name": "Smartphone",
    "category": "electronics",
    "price": 299.99,
    "inStock": true,
    "rating": 4.5,
    "createdAt": "2023-01-15T12:00:00Z"
  },
  {
    "id": 2,
    "name": "Laptop",
    "category": "electronics",
    "price": 899.99,
    "inStock": true,
    "rating": 4.7,
    "createdAt": "2023-03-20T08:30:00Z"
  }
]


## Dependencies
### The project relies on the following dependencies:

Spring Boot Starter Web
Spring Boot Starter Data JPA
MySQL Connector Java
Lombok
Spring Boot Starter Test
Mockito
