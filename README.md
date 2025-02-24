
# Vendor Management CRUD API  

A RESTful CRUD API built with **Spring Boot** for managing vendor information. It includes standard CRUD operations with error handling and validation.

## Features  
- Create, Read, Update, and Delete (CRUD) operations for vendor data  
- RESTful API endpoints with **Spring Boot**  
- Exception handling and validation  
- Database integration using **Spring Data JPA**  
- Unit testing with JUnit  

## Technologies Used  
- Java  
- Spring Boot  
- Spring Data JPA  
- Maven  
- H2/MySQL Database  

## Installation  

### Prerequisites  
- Java 11 or later  
- Maven  
- MySQL or any other relational database  

### Steps to Run  
1. Clone the repository  
   `git clone https://github.com/YOUR_USERNAME/Vendor-CRUD-API.git`  
   `cd Vendor-CRUD-API`  

2. Configure the database in `src/main/resources/application.properties`  
   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/vendor_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Build and run the application  
   `mvn clean install`  
   `mvn spring-boot:run`  

## API Endpoints  

| Method | Endpoint       | Description       |
|--------|--------------|------------------|
| GET    | `/vendors`   | Get all vendors  |
| GET    | `/vendors/{id}` | Get vendor by ID |
| POST   | `/vendors`   | Create a new vendor |
| PUT    | `/vendors/{id}` | Update vendor details |
| DELETE | `/vendors/{id}` | Delete a vendor |

## Contribution  
1. Fork the repository  
2. Create a new branch  
   `git checkout -b feature-branch`  
3. Commit your changes  
   `git commit -m "Added new feature"`  
4. Push to the branch  
   `git push origin feature-branch`  
5. Submit a pull request  

