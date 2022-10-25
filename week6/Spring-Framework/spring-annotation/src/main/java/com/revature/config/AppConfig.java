package com.revature.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.revature") //Specify what package Spring should look into for components
public class AppConfig {
    
    //What if the creation logic of a class is a lot more complicated than a simple "new ...."
    
}
