package com.revature.model;

import java.util.Objects;

public class Assignment {

    private int id;
    private String assignmentName;
    private int grade; // 0 default
    private int studentId;
    private int graderId; // 0 default

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
