package com.revature.repository;

import com.revature.model.Assignment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AssignmentRepository {

    public List<Assignment> getAllAssignments() throws SQLException {
        try (Connection connectionObject = ConnectionFactory.createConnection()) {

            List<Assignment> assignments = new ArrayList<>();

            String sql = "SELECT * FROM assignments";

            Statement stmt = connectionObject.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // ResultSet represents the temporary table of query results

            // Iterating through the ResultSet
            while (rs.next()) {
                int id = rs.getInt("id");
                String assignmentName = rs.getString("assignment_name");
                int grade = rs.getInt("grade");
                int studentId = rs.getInt("student_id");
                int graderId = rs.getInt("grader_id");

                Assignment assignment = new Assignment(id, assignmentName, grade, studentId, graderId);

                assignments.add(assignment); // add assignment to List
            }

            return assignments;
        }
    }

    public List<Assignment> getAllAssignmentsForStudent(int studentId) throws SQLException {
        try (Connection connectionObject = ConnectionFactory.createConnection()) {

            List<Assignment> assignments = new ArrayList<>();

            String sql = "SELECT * FROM assignments WHERE student_id = ?";

            PreparedStatement pstmt = connectionObject.prepareStatement(sql);

            pstmt.setInt(1, studentId);

            ResultSet rs = pstmt.executeQuery();
            // ResultSet represents the temporary table of query results

            // Iterating through the ResultSet
            while (rs.next()) {
                int id = rs.getInt("id");
                String assignmentName = rs.getString("assignment_name");
                int grade = rs.getInt("grade");
                int sId = rs.getInt("student_id");
                int graderId = rs.getInt("grader_id");

                Assignment assignment = new Assignment(id, assignmentName, grade, sId, graderId);

                assignments.add(assignment); // add assignment to List
            }

            return assignments;
        }
    }

    public boolean gradeAssignment(int assignmentId, int grade, int graderId) throws SQLException {
        try (Connection connectionObj = ConnectionFactory.createConnection()) {
            String sql = "UPDATE assignments SET grade = ?, grader_id = ? WHERE id = ?";

            PreparedStatement pstmt = connectionObj.prepareStatement(sql);
            pstmt.setInt(1, grade);
            pstmt.setInt(2, graderId);
            pstmt.setInt(3, assignmentId);

            int numberOfRecordsUpdated = pstmt.executeUpdate();

            return numberOfRecordsUpdated == 1;
        }
    }

    // Returns either
    // 1. An assignment object
    // 2. null
    public Assignment getAssignmentById(int id) throws SQLException {
        try (Connection connectionObj = ConnectionFactory.createConnection()) {
            String sql = "SELECT * FROM assignments WHERE id = ?";

            PreparedStatement pstmt = connectionObj.prepareStatement(sql);

            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery(); // 0 rows or 1 row

            if (rs.next()) {
                int assignmentId = rs.getInt("id");
                String assignmentName = rs.getString("assignment_name");
                int grade = rs.getInt("grade");
                int studentId = rs.getInt("student_id");
                int graderId = rs.getInt("grader_id");

                return new Assignment(assignmentId, assignmentName, grade, studentId, graderId);
            } else {
                return null;
            }
        }
    }
}
