package com.revature.service;

import com.revature.model.Assignment;
import com.revature.repository.AssignmentRepository;

import java.sql.SQLException;
import java.util.List;

public class AssignmentService {

    private AssignmentRepository assignmentRepository = new AssignmentRepository();

    public List<Assignment> getAllAssignments() throws SQLException {
        return assignmentRepository.getAllAssignments();
    }

}
