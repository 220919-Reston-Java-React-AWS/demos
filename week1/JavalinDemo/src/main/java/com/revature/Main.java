package com.revature;

import com.revature.model.User;
import com.revature.repository.UserRepository;
import com.revature.service.AuthService;
import com.revature.service.UserService;
import io.javalin.Javalin;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Javalin app = Javalin.create();

        AuthService authService = new AuthService();
        UserService userService = new UserService();

        // When the application receives the GET / request, it will execute the code inside of the lambda expression
        app.get("/", (ctx) -> { // lambda expression (...) -> { }
//            throw new RuntimeException();
            // If you have an unhandled exception, the server will send an HTTP response with a status code
            // of 500 Internal Server Error
            // 5XX status codes should be avoided
            ctx.status(200);
            ctx.result("Hello World!");
        });

        // Client sends a request that contains information that they would like to use to register for an account
        app.post("/register", (ctx) -> {
            User user = ctx.bodyAsClass(User.class); // Take the data from the HTTP request (JSON format) and place that data
            // into a User object that we can utilize

            try {
                authService.register(user);

                ctx.status(201);
            } catch (IllegalArgumentException e) {
                ctx.result(e.getMessage());
                ctx.status(400);
            }
        });

        app.get("/users", (ctx) -> {
            List<User> users = userService.getAllUsers();

            ctx.json(users);
        });

        app.start(8080); // Run server on port 8080
    }

}
