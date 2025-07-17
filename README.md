Prerequisites
Make sure you have the following installed:
Java 17+
Maven (optional if using ./mvnw)
PostgreSQL running locally
(Optional) Docker if you want to run via container

Database Setup
First you gotta create Db using this sql query:
CREATE DATABASE financial_product;

Update credentials in application.properties
spring.datasource.username=your_postgres_username
spring.datasource.password=your_postgres_password

!Now you can run the project

!Once you run the project mock data will be saved in DB.
