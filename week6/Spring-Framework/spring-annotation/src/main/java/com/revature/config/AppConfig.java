package com.revature.config;

import com.revature.dao.PokemonDao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.revature") //Specify what package Spring should look into for components
public class AppConfig {
    
    //What if the creation logic of a class is a lot more complicated than a simple "new ...."
    //Another way to specify how to make a Bean by using a Bean annotation within our AppConfig
    @Bean(name = "PokemonDao")
    public PokemonDao getPokemonDao() {
        System.out.println("executing complicated creation logic to make my PokemonDao");
        return new PokemonDao();
    }
}
