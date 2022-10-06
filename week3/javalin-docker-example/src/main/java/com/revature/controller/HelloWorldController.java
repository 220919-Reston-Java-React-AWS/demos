package com.revature.controller;

import io.javalin.Javalin;

public class HelloWorldController {

    public void mapEndpoints(Javalin app) {

        // POSTMAN
        // GET http://127.0.0.1:8080/reimbursements

        app.get("/reimbursements", (ctx) -> {
            String status = ctx.queryParam("status");

                        // Finance manager functionality
                        if (status.equals("pending")) {
                            // code to retrieve pending reimbursements
                        } else if (status.equals("approved")) {
                            // code to retrieve approved reimbursements
                        } else if (status.equals("denied")) {
                            // code to retrieve denied reimbursements
                        } else { // no valid query param value
                            // Code to get all reimbursements regardless of status
                        }


        });

    }

}
