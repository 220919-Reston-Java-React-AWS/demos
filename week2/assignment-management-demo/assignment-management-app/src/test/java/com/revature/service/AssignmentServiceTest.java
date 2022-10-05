package com.revature.service;

import com.revature.exception.AssignmentAlreadyGradedException;
import com.revature.exception.AssignmentNotFoundException;
import com.revature.model.Assignment;
import com.revature.repository.AssignmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AssignmentServiceTest {

    @Mock
    private AssignmentRepository assignmentRepository; // Create a mock object (AssignmentRepository)

    @InjectMocks
    private AssignmentService as; // Construct an AssignmentService object that utilizes the mock AssignmentRepository by injecting the mock into the object

    // Negative test
    @Test
    public void testGradeAssignmentGradeIsNegative() throws SQLException, AssignmentAlreadyGradedException, AssignmentNotFoundException {
        // AAA
        // Arrange

        // Act + Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            as.gradeAssignment(1, -10, 100);
        });
    }

    // Negative test
    @Test
    public void testGradeAssignmentAssignmentDoesNotExist() throws SQLException {
        // AAA
        // Arrange

        // Mocking a response from assignmentRepository
        when(assignmentRepository.getAssignmentById(eq(100))).thenReturn(null);

        // Act + Assert
        Assertions.assertThrows(AssignmentNotFoundException.class, () -> {
            as.gradeAssignment(100, 85, 2);
        });
    }

    // Negative test
    @Test
    public void testGradeAssignmentExistsButAlreadyGraded() throws SQLException {
        // Arrange
        when(assignmentRepository.getAssignmentById(eq(1))).thenReturn(new Assignment(1, "Homework 1", 50, 100, 99));

        // Act + Assert
        Assertions.assertThrows(AssignmentAlreadyGradedException.class, () -> {
            as.gradeAssignment(1, 90, 10);
        });
    }

    // Positive test
    @Test
    public void testGradeAssignmentPositive() throws SQLException, AssignmentAlreadyGradedException, AssignmentNotFoundException {
        // Arrange
        when(assignmentRepository.getAssignmentById(eq(1))).thenReturn(new Assignment(1, "Homework 10", 0, 100, 0));

        when(assignmentRepository.gradeAssignment(eq(1), eq(96), eq(150))).thenReturn(true);

        // Act
        boolean actual = as.gradeAssignment(1, 96, 150);

        // Assert
        Assertions.assertTrue(actual);
    }

}
