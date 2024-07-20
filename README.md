# Loqoai Assignment Project

## REST API for Product Management

We have developed this REST API for managing products. This API provides functionality to filter and sort product records using various criteria.

## Modules

- Product Management Module

## Features

- **Product Management Features:**
  - Add a new product to the system.
  - Retrieve products with filtering and sorting capabilities based on category, price range, stock availability, and other criteria.

## Tech Stack

- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok

## API Endpoints
### Add a Product

POST /products
Content-Type: application/json

Request:
{
  "name": "Product1",
  "category": "Category1",
  "price": 10.0,
  "inStock": true,
  "rating": 4.5
}

Response:

HTTP/1.1 200 OK
Content-Type: application/json

{
  "id": 1,
  "name": "Product1",
  "category": "Category1",
  "price": 10.0,
  "inStock": true,
  "rating": 4.5,
  "createdAt": "2023-07-20T12:34:56.789+00:00"
}

## Get Products with Filtering and Sorting

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




## Contributors

- <a href="https://github.com/bhupirao">Bhoop Singh</a>

## Installation and Run

### Clone the repository:

git clone https://github.com/your-repo/loqoai-demo.git
cd loqoai-demo

### Build the application:

mvn clean install

### Run the application:

mvn spring-boot:run

### Run Tests

mvn test


### Update Database Configuration

Before running the API server, update the database configuration inside the `application.properties` file with your database details:

```properties
server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/your-database
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=your-username
spring.datasource.password=your-password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
   

