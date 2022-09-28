package com.revature;

import com.revature.controller.AssignmentController;
import com.revature.controller.AuthController;
import com.revature.model.Assignment;
import com.revature.model.User;
import com.revature.repository.AssignmentRepository;
import com.revature.repository.UserRepository;
import io.javalin.Javalin;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Javalin app = Javalin.create();

        AuthController ac = new AuthController();
        ac.mapEndpoints(app);

        AssignmentController assignmentController = new AssignmentController();
        assignmentController.mapEndpoints(app);

        app.start(8080);
    }

}
