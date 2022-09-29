package com.revature.controller;

import com.revature.exception.InvalidLoginException;
import com.revature.model.User;
import com.revature.service.AuthService;
import io.javalin.Javalin;

import javax.servlet.http.HttpSession;

public class AuthController {

    private AuthService authService = new AuthService();

    public void mapEndpoints(Javalin app) {
        app.post("/login", (ctx) -> {
            User credentials = ctx.bodyAsClass(User.class); // Take the JSON in the request body and place it into the user Object
//            private int id; -> 0
//            private String username; (USED)
//            private String password; (USED)
//            private String firstName; -> null
//            private String lastName; -> null
//            private int role_id; -> 0
            try {
                User user = authService.login(credentials.getUsername(), credentials.getPassword());

                HttpSession session = ctx.req.getSession(); // get the HttpSession (there is a cookie that is utilized by the client to identify the HttpSession object
                // associated with the client
                session.setAttribute("user", user); // Store the user object into an HttpSession object
            } catch (InvalidLoginException e) {
                ctx.status(400); // 400 Bad Request
                ctx.result(e.getMessage());
            }
        });

        app.post("/logout", (ctx) -> {
            ctx.req.getSession().invalidate(); // Invalidate an active HttpSession
        });

//        app.get("/currentuser", (ctx) -> {
//            HttpSession session = ctx.req.getSession();
//
//            User user = (User) session.getAttribute("user");
//
//            if (user != null) {
//                ctx.json(user);
//            } else {
//                ctx.result("User is not logged in!");
//                ctx.status(400);
//            }
//        });
    }

}
