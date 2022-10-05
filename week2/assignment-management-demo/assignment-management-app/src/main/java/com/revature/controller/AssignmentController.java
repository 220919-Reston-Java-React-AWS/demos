package com.revature.controller;

import com.revature.exception.AssignmentAlreadyGradedException;
import com.revature.exception.AssignmentNotFoundException;
import com.revature.model.Assignment;
import com.revature.model.User;
import com.revature.service.AssignmentService;
import io.javalin.Javalin;

import javax.servlet.http.HttpSession;
import java.util.List;

public class AssignmentController {

    private AssignmentService assignmentService = new AssignmentService();

    public void mapEndpoints(Javalin app) {

        // GET /assignments works is different depending on whether we're logged in as a trainer or a student
        // If we are logged in as a trainer, then it will retrieve all assignments from the system
        // If we are logged in as a student, then it will retrieve assignments belonging to us
        app.get("/assignments", (ctx) -> {
            // We must be logged in as a trainer
            HttpSession httpSession = ctx.req.getSession();

            // retrieve the user object from user attribute
            User user = (User) httpSession.getAttribute("user");

            if (user != null) { // Check if logged in
                if (user.getRoleId() == 2) { // if they are a trainer
                    List<Assignment> assignments = assignmentService.getAllAssignments();

                    ctx.json(assignments);
                } else if (user.getRoleId() == 1) { // if they are a student
                    int studentId = user.getId();

                    List<Assignment> assignments = assignmentService.getAllAssignmentsForStudent(studentId);

                    ctx.json(assignments);
                } else {
                    ctx.result("You are logged in, but you're not a trainer or student");
                    ctx.status(401);
                }
            } else {
                ctx.result("You are not logged in!");
                ctx.status(401);
            }
        });

        app.patch("/assignments/{assignmentId}", (ctx) -> {

            HttpSession httpSession = ctx.req.getSession();
            User user = (User) httpSession.getAttribute("user");

            if (user != null) { // Check if logged in
                // Check if user is a trainer
                if (user.getRoleId() == 2) {
                    int graderId = user.getId();
                    int assignmentId = Integer.parseInt(ctx.pathParam("assignmentId"));

                    Assignment a = ctx.bodyAsClass(Assignment.class); // JSON: { grade: 85 }
                    int grade = a.getGrade();

                    try {
                        assignmentService.gradeAssignment(assignmentId, grade, graderId);

                        ctx.result("Assignment successfully graded!");
                    } catch (AssignmentAlreadyGradedException | IllegalArgumentException e) {
                        ctx.result(e.getMessage());
                        ctx.status(400);
                    } catch (AssignmentNotFoundException e) {
                        ctx.result(e.getMessage());
                        ctx.status(404); // 404 NOT FOUND
                    }

                } else {
                    ctx.result("You are logged in, but you are not a trainer!");
                    ctx.status(401);
                }
            } else {
                ctx.result("You are not logged in!");
                ctx.status(401);
            }

        });

        // Endpoint is for students to view their own assignments
//        app.get("/users/{userId}/assignments", (ctx) -> {
//            HttpSession httpSession = ctx.req.getSession();
//
//            User user = (User) httpSession.getAttribute("user");
//
//            if (user != null) { // Check if logged in
//                if (user.getRoleId() == 1) { // if they are a student
//                    // Check if user is who they say they are
//                    int userId = Integer.parseInt(ctx.pathParam("userId")); // convert String into int
//                    if (user.getId() == userId) {
//                        List<Assignment> assignments = assignmentService.getAllAssignmentsForStudent(userId);
//                        ctx.json(assignments);
//                    } else {
//                        ctx.result("You are not logged in as the user you are trying to retrieve assignments from");
//                        ctx.status(401);
//                    }
//                } else {
//                    ctx.result("You are logged in, but you're not a student!");
//                    ctx.status(401);
//                }
//            } else {
//                ctx.result("You are not logged in!");
//                ctx.status(401);
//            }
//        });
    }

}
