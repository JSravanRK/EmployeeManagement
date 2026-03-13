
# Employee Management System (Java + MySQL)

A simple **Java Console-based Employee Management System** that performs **CRUD (Create, Read, Update, Delete)** operations using **JDBC and MySQL**.

This project was developed as part of an internship task to demonstrate understanding of:
- Java OOP concepts
- CLI application design
- JDBC connectivity
- MySQL database integration
- DAO (Data Access Object) pattern

---

## Features

- Add a new employee
- View employee details by ID
- Update employee information
- Delete an employee record
- View all employees
- Data persistence using MySQL

---

## Technologies Used

- Java
- JDBC
- MySQL
- VS Code
- MySQL Workbench

---

## Project Structure

```
EmployeeManagement
│
├── src/com/sj/empmanagmentapplication
│       Main.java
│       Employee.java
│       EmployeeService.java
│       EmployeeDAO.java
│       DBConnection.java
│
├── lib
│       mysql-connector-j.jar
│
├── bin
│       (compiled class files)
│
└── README.md
```

---

## Database Setup

Open **MySQL Workbench** and run the following SQL commands:

```sql
CREATE DATABASE employee_db;

USE employee_db;

CREATE TABLE employees(
 id INT PRIMARY KEY,
 name VARCHAR(100),
 age INT,
 designation VARCHAR(100),
 department VARCHAR(100),
 salary DOUBLE
);
```

---

## Configure Database Connection

Update the credentials in `DBConnection.java`:

```java
private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
private static final String USER = "root";
private static final String PASSWORD = "your_mysql_password";
```

---

## Compile the Project

Run the following command in the project root folder:

```
javac -cp "lib/*" -d bin src/com/sj/empmanagmentapplication/*.java
```

---

## Run the Application

```
java -cp "bin;lib/*" com.sj.empmanagmentapplication.Main
```

---

## Application Menu

```
1. Add Employee
2. View Employee
3. Update Employee
4. Delete Employee
5. View All Employees
6. Exit
```

---

## Example Output

```
Enter your choice: 1
Enter id: 101
Enter name: Sravan
Enter age: 21
Enter designation: Developer
Enter department: IT
Enter salary: 50000

Employee added successfully
```

---

## Learning Outcomes

- Implemented CRUD operations using Java
- Learned JDBC database connectivity
- Designed a layered architecture using Service and DAO classes
- Built a CLI-based management system

---

## Author

**Vemuri Sravan Ram Kumar**  
B.Tech Student
