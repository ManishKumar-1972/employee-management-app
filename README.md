# 🧑‍💼 Employee Management App

A full-stack Employee Management Application built with **Spring Boot (Java)**, **ReactJS**, **MySQL**, and **Docker**. This app supports adding, viewing, and deleting employee records with real-time updates and automated testing.

---

## 🚀 Features

- Add new employees with form validation
- View and manage employee list
- Delete employees with confirmation
- Toast notifications for actions
- Full Docker containerization
- Automated Selenium BDD Tests (Java + Cucumber)

---

## 🛠️ Tech Stack

- **Frontend**: ReactJS, Axios, Toastify  
- **Backend**: Spring Boot, Spring Data JPA, MySQL  
- **Database**: MySQL  
- **Testing**: Selenium WebDriver + Cucumber + JUnit  
- **DevOps**: Docker, Docker Compose  

---

## 🐳 Run with Docker

```bash
docker-compose up --build
```

Access the app at:  
Frontend → `http://localhost:3000`  
Backend API → `http://localhost:8080`  
Database → `localhost:3307` (MySQL)

---

## 🧪 Run Automated Tests

```bash
mvn test
```

Uses Selenium + Cucumber to test:
- Add Employee
- Validation
- Delete Employee

---

## 📂 Project Structure

```
employee-management-app/
├── backend/
│   └── employee-management/       # Spring Boot backend
├── frontend/
│   └── employee-management-ui/    # React frontend
├── docker-compose.yml
├── README.md
└── .gitignore
```

---

## 📌 Author

**Manish Kumar**  
GitHub: [ManishKumar-1972](https://github.com/ManishKumar-1972)

---

> ⭐ If you like this project, please consider giving it a star on GitHub.

