package com.revature.repository;

import com.revature.model.User;

import java.sql.*;

// Will contain JDBC code to interact with the database
// It will help in supporting the various functionalities that our application requires
public class UserRepository {

    // Registration
    public User addUser(User user) throws SQLException { // Create in CRUD
        // try-with-resources: new syntax
        // try-with-resources is used to automatically close the Connection object when the block of code is finished
        // it will essentially automatically call the connectionObject.close();
        try (Connection connectionObject = ConnectionFactory.createConnection()) {
            String sql = "insert into users (username, password, first_name, last_name, role_id) values (?, ?, ?, ?, ?)";

            // Create PreparedStatement object using a pre-defined template (? are used as placeholders for values)
            PreparedStatement pstmt = connectionObject.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getFirstName());
            pstmt.setString(4, user.getLastName());
            pstmt.setInt(5, 1); // role_id 1 represents a student. We're hardcoding 1 because when we add
            // a user, we want for the added user to default to the student role

            int numberOfRecordsAdded = pstmt.executeUpdate(); // applies to INSERT, UPDATE, and DELETE

            // Get automatically generated ID
            ResultSet rs = pstmt.getGeneratedKeys(); // produce a temporary table that contains 1 column and 1 row
            // representing the automatically generated primary key
            rs.next(); // retrieve the first row in the temporary table
            int id = rs.getInt(1); // Get 1st column from temporary table

            return new User(id, user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), 1);
        }
    }

    // Login
    public User getUserByUsernameAndPassword(String username, String password) throws SQLException { // Read in CRUD
        try (Connection connectionObj = ConnectionFactory.createConnection()) {
            String sql = "SELECT * FROM users as u WHERE u.username = ? AND u.password = ?";
            PreparedStatement pstmt = connectionObj.prepareStatement(sql);

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery(); // ResultSet represents a temporary table that contains all data that we have
            // queried for

            if (rs.next()) { // returns a boolean indicating whether there is a record or not for the "next" row AND iterates to the next row
                int id = rs.getInt("id");
                String un = rs.getString("username");
                String pw = rs.getString("password");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int roleId = rs.getInt("role_id");

                return new User(id, un, pw, firstName, lastName, roleId);
            } else {
                return null;
            }

        }
    }

}
