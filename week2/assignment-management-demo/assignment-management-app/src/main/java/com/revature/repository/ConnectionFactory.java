package com.revature.repository;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection createConnection() throws SQLException {
        // 1. Register the postgres driver with the DriverManager class from JDBC
        Driver postgresDriver = new Driver();
        DriverManager.registerDriver(postgresDriver);

        // 2. Define the database location (URL / Connection String) and username and password
        String url = "jdbc:postgresql://127.0.0.1:5432/postgres";

        // THIS IS TERRIBLE PRACTICE BECAUSE YOU ARE EXPOSING DATABASE CREDENTIALS ESPECIALLY IF YOU PUSH TO A PUBLIC
        // GITHUB repository
        // In this case, it doesn't matter because my database is local to my computer (127.0.0.1), and nobody on the internet
        // will be able to access it

        // String username = "postgres";
        // String password = "password"; // Put whatever your password actually is to "login" to the database

        // Best practice: use either a properties file that is not going to be pushed to Github that your program will
        // read from, or use ENVIRONMENT VARIABLES
        // -> Environment Variable: A variable that exists on your operating system itself that ANY programs can access,
        // not just a single application

        String username = System.getenv("database_username"); // System.getenv is used to read the value of an environment variable
        String password = System.getenv("database_password"); // System.getenv is used to read the value of an environment variable

        Connection connectionObject = DriverManager.getConnection(url, username, password);

        return connectionObject;
    }

}
