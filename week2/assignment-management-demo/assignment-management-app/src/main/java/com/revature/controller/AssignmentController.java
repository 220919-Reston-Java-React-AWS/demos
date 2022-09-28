package com.revature.controller;

import com.revature.model.Assignment;
import com.revature.model.User;
import com.revature.service.AssignmentService;
import io.javalin.Javalin;

import javax.servlet.http.HttpSession;
import java.util.List;

public class AssignmentController {

    private AssignmentService assignmentService = new AssignmentService();

    public void mapEndpoints(Javalin app) {
        app.get("/assignments", (ctx) -> {
            // We must be logged in as a trainer
            HttpSession httpSession = ctx.req.getSession();

            // retrieve the user attribute
            User user = (User) httpSession.getAttribute("user");

            if (user != null) { // Check if logged in
                if (user.getRoleId() == 2) { // if they are a trainer
                    List<Assignment> assignments = assignmentService.getAllAssignments();

                    ctx.json(assignments);
                } else {
                    ctx.result("You are logged in, but you're not a trainer!");
                    ctx.status(401); // 401 UNAUTHORIZED
                }
            } else {
                ctx.result("You are not logged in!");
                ctx.status(401);
            }

        });
    }

}
