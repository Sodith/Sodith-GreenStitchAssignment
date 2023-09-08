# Sodith-GreenStitchAssignment

Employee API Documentation
This documentation provides information on how to interact with the Employee API, which allows you to manage employee data, authenticate users, and retrieve a simple greeting message.

Register Employee
Register a new employee by sending a POST request to the following URL:

URL: http://localhost:8080/employee

Request
In the request body, include the following JSON data:

json
Copy code
{
    "userName": "employee_username",
    "password": "employee_password",
    "first_Name": "John",
    "last_Name": "Doe",
    "position": "Manager",
    "department": "HR"
}
Response
Upon successful registration, you will receive a response with the newly created employee's details.

json
Copy code
{
    "id": 1,
    "userName": "employee_username",
    "password": "employee_password",
    "first_Name": "John",
    "last_Name": "Doe",
    "position": "Manager",
    "department": "HR"
}
Login
Authenticate an employee and generate an access token by sending a POST request to the following URL:

URL: http://localhost:8080/authenticate

Request
In the request body, provide the employee's credentials:

json
Copy code
{
    "userName": "employee_username",
    "password": "employee_password"
}
Response
Upon successful authentication, you will receive an access token, which can be used for further API requests.

json
Copy code
{
    "accessToken": "your_access_token"
}
Get Hello Message
Retrieve a simple greeting message by sending a GET request to the following endpoint:

Endpoint: GET /hello

Request
URL: http://localhost:8080/hello

Response
You will receive a greeting message from the GreenStitch application.

json
Copy code
{
    "message": "Hello from GreenStitch"
}


Database Configuration
Database Setup: Make sure you have MySQL installed and running on your system. Create a MySQL database named DBName if it doesn't exist already. You can do this using a tool like phpMyAdmin or by running SQL commands.

Database Connection Configuration: In your application.properties (or application.yml) file, you already have the database connection properties configured as follows:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/DBName
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
Make sure to replace your-secret-key with your actual MySQL root password and ensure that the MySQL server is running on localhost and listening on port 3306. Also, ensure that the DBName matches the name of your database.

Optional Logging Configuration: The provided logging configuration is useful for debugging purposes and can help you see SQL queries. You can keep these settings as-is if you want to log SQL queries.

H2 In-Memory Database (Optional): If you intend to use an H2 in-memory database for testing or development, you can uncomment the H2 database properties and comment out the MySQL properties. However, for a production environment, it's recommended to use a dedicated database like MySQL.

Instructions for Connecting to the Database
Create Database: As mentioned earlier, make sure you've created the MySQL database named DBName using MySQL command-line tools or a database management tool like phpMyAdmin.

MySQL Server: Ensure that your MySQL server is up and running. You can start it using the appropriate command for your operating system.

Application Configuration: Make sure your Spring Boot application is correctly configured with the application.properties file containing the database connection details.

Database Access: In your Spring Boot application code, you should have a repository or service layer that interacts with the database using Spring Data JPA or a similar framework. Ensure that these components are correctly configured to access the MySQL database.

Run the Application: Build and run your Spring Boot application. It should now connect to the MySQL database using the provided configuration.

Please replace your-secret-key, root, 123456, and DBName with your actual database credentials and database name. Additionally, ensure that your MySQL server is configured to allow connections from the application server.
