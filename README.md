# 🏦 InCredit - Credit Risk Assessment API

A Java Spring Boot-based RESTful API that analyzes customer credit risk using regression techniques. This application allows importing customer data from JSON files, storing it in a PostgreSQL database, and performing credit risk assessments.

---

## 📌 Features

- Import customer data from a JSON file.
- Store and manage customers in PostgreSQL.
- Perform credit risk assessment using Apache Commons Math.
- REST APIs for CRUD operations and analysis.
- Supports Java 8 date types (`LocalDate`) using Jackson.
- Clean, modular code with service and controller layers.

---

## 🛠️ Tech Stack

- Java 17  
- Spring Boot  
- PostgreSQL  
- Apache Commons Math (Regression)  
- Jackson (JSON Parsing)  
- Maven  

---

## 🚀 How to Run

1. **Clone the Repository**

```bash
git clone https://github.com/yourusername/incredit.git
cd incredit
Configure PostgreSQL

Create a new PostgreSQL database named incredit_db.

Update the src/main/resources/application.properties file with your credentials:

properties
spring.datasource.url=jdbc:postgresql://localhost:5432/incredit_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
Build and Run the Application

bash
mvn spring-boot:run
The server will start on: http://localhost:8080

Sample JSON Format for Import
json
[
  {
    "name": "John Doe",
    "dob": "1990-05-12",
    "income": 50000,
    "creditScore": 720,
    "loanAmount": 15000
  },
  {
    "name": "Jane Smith",
    "dob": "1985-11-23",
    "income": 65000,
    "creditScore": 690,
    "loanAmount": 20000
  }
]
🧪 REST API Endpoints
Method	Endpoint	Description
POST	/api/customers/import	Import customers from JSON
GET	/api/customers	Get all customers
GET	/api/customers/{id}	Get customer by ID
GET	/api/customers/risk	Perform credit risk analysis on data

🧪 How to Test with Postman
Open Postman.

Create a request:

Method: POST

URL: http://localhost:8080/api/customers/import

Body: raw JSON (see sample format above)

Headers:

Content-Type: application/json

Send and verify the response: Customer data imported successfully.

Test other endpoints like GET /api/customers or /api/customers/risk.

📄 Project Structure
matlab
Copy
Edit
incredit/
├── controller/
│   └── CustomerController.java
├── model/
│   └── Customer.java
├── repository/
│   └── CustomerRepository.java
├── service/
│   └── CustomerService.java
├── resources/
│   └── application.properties
└── IncreditApplication.java
👨‍💻 Author
Lalita Kumari
Java Backend Developer
Email: lalitarana543@gmail.com
GitHub: https://github.com/lalitarana123456
