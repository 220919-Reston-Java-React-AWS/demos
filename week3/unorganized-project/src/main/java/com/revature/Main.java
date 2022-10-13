package com.revature;

import io.javalin.Javalin;
import jakarta.servlet.http.HttpSession;
import org.postgresql.Driver;

import java.sql.*;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Javalin app = Javalin.create();

        // This endpoint POST /users is for registering a new user with a default role of "student"
        app.post("/users", (ctx) -> {
            User registrationInformation = ctx.bodyAsClass(User.class); // Take the JSON in the request body and place the data into a User object

            // Check if user with username already exists
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:1000/postgres", "postgres", "12345");
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE username = ?");
            pstmt.setString(1, registrationInformation.getUsername());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                ctx.result("Username " + registrationInformation.getUsername() + " already exists!");
                ctx.status(400);
            } else {
                // Put user into the database
                PreparedStatement pstmt2 = con.prepareStatement("INSERT INTO users (first_name, last_name, username, password, role) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                pstmt2.setString(1, registrationInformation.getFirstName());
                pstmt2.setString(2, registrationInformation.getLastName());
                pstmt2.setString(3, registrationInformation.getUsername());
                pstmt2.setString(4, registrationInformation.getPassword());
                pstmt2.setString(5, "student");

                int numberOfRecordsUpdated = pstmt2.executeUpdate();

                if (numberOfRecordsUpdated == 1) {
                    ResultSet r = pstmt2.getGeneratedKeys();
                    r.next();
                    int autoGeneratedId = r.getInt(1);

                    ctx.json(new User(autoGeneratedId, registrationInformation.getUsername(), registrationInformation.getPassword(), registrationInformation.getFirstName(), registrationInformation.getLastName(), "student"));
                    ctx.status(201);
                }
            }

        });

        app.post("/login", (ctx) -> {
           User loginInformation = ctx.bodyAsClass(User.class);

            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:1000/postgres", "postgres", "12345");
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            pstmt.setString(1, loginInformation.getUsername());
            pstmt.setString(2, loginInformation.getPassword());

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String role = rs.getString("role");

                User user = new User(id, firstName, lastName, username, password, role);

                // Set the user object into the HttpSession (which keeps track of the person who is logged in)
                HttpSession session = ctx.req().getSession();
                session.setAttribute("logged_in_user", user);

                ctx.json(user);
                ctx.status(200);
            } else {
                ctx.result("Invalid username and/or password");
                ctx.status(400);
            }

        });

        app.post("/assignments", (ctx) -> {
            Assignment assignmentInfo = ctx.bodyAsClass(Assignment.class);

           HttpSession session = ctx.req().getSession();
           User user = (User) session.getAttribute("logged_in_user");

           if (user != null) {
               if (user.getRole().equals("student")) {
                   // Insert assignment into database
                   Driver driver = new Driver();
                   DriverManager.registerDriver(driver);

                   Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:1000/postgres", "postgres", "12345");

                   PreparedStatement pstmt = con.prepareStatement("INSERT INTO assignments (assignment_name, student_id) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
                   pstmt.setString(1, assignmentInfo.getAssignmentName());
                   pstmt.setInt(2, user.getId());

                   if (pstmt.executeUpdate() == 1) {
                       ResultSet r = pstmt.getGeneratedKeys();
                       r.next();
                       int autogeneratedId = r.getInt(1);

                       ctx.json(new Assignment(autogeneratedId, assignmentInfo.getAssignmentName(), 0, user.getId(), 0));
                       ctx.status(201);
                   }

               } else {
                   ctx.result("HEY! You're not a student, so you're not allowed to submit assignments!");
                   ctx.status(401); // 401 UNAUTHORIZED
               }
           } else {
               ctx.result("You're not logged in!");
               ctx.status(401); // 401 UNAUTHORIZED
           }

        });

        app.start(8080);
    }

}

class Assignment {
    private int id;
    private String assignmentName;
    private int grade;
    private int studentId;
    private int graderId;

    public Assignment() {
    }

    public Assignment(int id, String assignmentName, int grade, int studentId, int graderId) {
        this.id = id;
        this.assignmentName = assignmentName;
        this.grade = grade;
        this.studentId = studentId;
        this.graderId = graderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getGraderId() {
        return graderId;
    }

    public void setGraderId(int graderId) {
        this.graderId = graderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment that = (Assignment) o;
        return id == that.id && grade == that.grade && studentId == that.studentId && graderId == that.graderId && Objects.equals(assignmentName, that.assignmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assignmentName, grade, studentId, graderId);
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", assignmentName='" + assignmentName + '\'' +
                ", grade=" + grade +
                ", studentId=" + studentId +
                ", graderId=" + graderId +
                '}';
    }
}

class User {
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    private String role;

    public User() {
    }

    public User(int id, String username, String password, String firstName, String lastName, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, firstName, lastName, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}