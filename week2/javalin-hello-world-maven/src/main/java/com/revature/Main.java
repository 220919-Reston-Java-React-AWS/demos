package com.revature;

import com.revature.controller.HelloWorldController;
import io.javalin.Javalin;

public class Main {

    public static void main(String[] args) {
        Javalin app = Javalin.create();

        HelloWorldController hwc = new HelloWorldController();
        hwc.mapEndpoints(app);

        app.start(8080);
    }

}
