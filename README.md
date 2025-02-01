# Fee Report

## Overview
The **Fee Report** project is a Java-based application that utilizes JDBC for backend operations and MySQL for database management. It provides an **Admin Portal** and a **Student Portal** for managing student fee records efficiently.

## Features
- **Admin Portal**
  - Add new student details along with their fee amount.
  - Update and delete student records.
  - View all student fee records.
  
- **Student Portal**
  - Check individual fee details.
  - View payment status.

## Technologies Used
- **Programming Language:** Java
- **Database:** MySQL
- **Backend:** JDBC (Java Database Connectivity)
- **IDE:** Eclipse / IntelliJ IDEA / NetBeans (any Java-supported IDE)

## Database Schema
### Student Table
| Column Name  | Data Type  | Description |
|-------------|-----------|-------------|
| id          | INT (Primary Key) | Unique ID for each student |
| name        | VARCHAR(255) | Name of the student |
| email       | VARCHAR(255) | Student's email address |
| course      | VARCHAR(255) | Course enrolled |
| fee         | DECIMAL(10,2) | Total fee amount |
| paid        | DECIMAL(10,2) | Amount paid |
| due         | DECIMAL(10,2) | Remaining balance |
| address     | VARCHAR(255) | Residential address |
| city        | VARCHAR(100) | City of residence |
| state       | VARCHAR(100) | State of residence |
| country     | VARCHAR(100) | Country of residence |
| contactno   | VARCHAR(15) | Contact number |

## Installation and Setup
1. **Clone the Repository:**
   ```sh
   git clone https://github.com/kinshuk8/Fee-Report.git
   ```
2. **Setup MySQL Database:**
   - Create a new database:
     ```sql
     CREATE DATABASE FeeReport;
     ```
   - Use the database:
     ```sql
     USE FeeReport;
     ```
   - Create the student table:
     ```sql
     CREATE TABLE students (
         id INT AUTO_INCREMENT PRIMARY KEY,
         name VARCHAR(255) NOT NULL,
         email VARCHAR(255) UNIQUE NOT NULL,
         course VARCHAR(255) NOT NULL,
         fee DECIMAL(10,2) NOT NULL,
         paid DECIMAL(10,2) NOT NULL,
         due DECIMAL(10,2) NOT NULL,
         address VARCHAR(255) NOT NULL,
         city VARCHAR(100) NOT NULL,
         state VARCHAR(100) NOT NULL,
         country VARCHAR(100) NOT NULL,
         contactno VARCHAR(15) NOT NULL
     );
     ```
3. **Configure Database Connection:**
   - Update database credentials in the Java code:
     ```java
     String url = "jdbc:mysql://localhost:3306/FeeReport";
     String user = "your-username";
     String password = "your-password";
     ```
4. **Run the Application:**
   - Compile and execute the Java application.

## Usage
- **Admin Login:**
  - Navigate to the Admin Portal and enter login credentials.
  - Add new students, update details, and manage fee records.
- **Student Login:**
  - Enter student credentials to check fee details.

## Future Enhancements
- Implement a graphical user interface (GUI) using Java Swing or JavaFX.
- Add authentication for admin and student logins.
- Integrate an online payment gateway.

## Contributing
Contributions are welcome! Feel free to fork this repository and submit a pull request.

## Contact
For any queries or suggestions, reach out to me at [saikinshuk.kontala@gmail.com].

