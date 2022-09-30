package com.revature.controller;

import io.javalin.Javalin;

public class HelloWorldController {

    public void mapEndpoints(Javalin app) {
        app.get("/hello", (ctx) -> {
           ctx.result("Hello world!");
        });
    }

}
