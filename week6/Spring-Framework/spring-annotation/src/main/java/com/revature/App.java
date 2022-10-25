package com.revature;

import com.revature.config.AppConfig;
import com.revature.model.Pokemon;
import com.revature.service.AbilityService;
import com.revature.service.PokemonService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Starting IoC container" );

        try (AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class)) {
            
            //Just like the previous container, you can grab beans via getBean method
            PokemonService pokeService = container.getBean(PokemonService.class);

            Pokemon poke1 = container.getBean(Pokemon.class);
            Pokemon poke2 = container.getBean(Pokemon.class);
            Pokemon poke3 = container.getBean(Pokemon.class);

            System.out.println(poke1.getName());
            System.out.println(poke2.getName());
            System.out.println(poke3.getName());


            AbilityService abserv = container.getBean(AbilityService.class);

            abserv.someMethod();

        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
