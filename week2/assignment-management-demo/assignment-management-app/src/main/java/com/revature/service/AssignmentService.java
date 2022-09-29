package com.revature.service;

import com.revature.exception.AssignmentAlreadyGradedException;
import com.revature.exception.AssignmentNotFoundException;
import com.revature.model.Assignment;
import com.revature.repository.AssignmentRepository;

import java.sql.SQLException;
import java.util.List;

public class AssignmentService {

    private AssignmentRepository assignmentRepository = new AssignmentRepository();

    public List<Assignment> getAllAssignments() throws SQLException {
        return assignmentRepository.getAllAssignments();
    }

    public List<Assignment> getAllAssignmentsForStudent(int studentId) throws SQLException {
       return assignmentRepository.getAllAssignmentsForStudent(studentId);
    }

    public boolean gradeAssignment(int assignmentId, int grade, int graderId) throws SQLException, AssignmentNotFoundException, AssignmentAlreadyGradedException {
        // Check if grade is negative
        if (grade < 0) {
            throw new IllegalArgumentException("Grades assigned must be 0 or higher"); // Built-in unchecked exception
        }

        // Check if assignment does not exist
        Assignment assignment = assignmentRepository.getAssignmentById(assignmentId);
        if (assignment == null) {
            throw new AssignmentNotFoundException("Assignment with id " + assignmentId + " was not found");
        }

        // Already graded
        if (assignment.getGrade() != 0 && assignment.getGraderId() != 0) {
            throw new AssignmentAlreadyGradedException("Assignment with id " + assignmentId + " has already been graded");
        }

        // Grading assignment
        return assignmentRepository.gradeAssignment(assignmentId, grade, graderId);
    }

}
