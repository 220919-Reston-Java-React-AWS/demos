package com.revature;

import com.revature.dao.PokemonDao;
import com.revature.model.Pokemon;
import com.revature.service.PokemonService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("======= The old way of creating objects =======");

        PokemonDao pokedao = new PokemonDao();
        PokemonService pokeserv = new PokemonService(pokedao);
        PokemonService pokeserv2 = new PokemonService(pokedao);
        PokemonService pokeserv3 = new PokemonService(pokedao);

        pokeserv.GetPokemons(); // 1 - Error (suppose to be static) or nah
    
        System.out.println("=================== Making Stateful Objects ===================");

        Pokemon poke1 = new Pokemon("Pikachu", 1, 10);
        Pokemon poke2 = new Pokemon("Ditto", 3, 70);
        Pokemon poke3 = new Pokemon("Bulbasaur", 10, 1000);
    
        //Having multiple objects out of stateful objects are very useful since not all objects are the same
        //Such as each pokemon having different names
        System.out.println(poke1.getName());
        System.out.println(poke2.getName());
        System.out.println(poke3.getName());

        System.out.println("===================== Spring way to creating objects =====================");

        try (ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("beans.xml")) {
            System.out.println("Starting IoC Container");
            /*
                As you note:
                Making the Spring IoC container automagically created our PokemonDao and service objects for us
                It is then our job to just use those beans and reference it
            */

            //How many beans do you think is created by Spring? 2 beans, 3 beans - 4
            //So only 2 beans because by default, Spring will just provide the Bean it already made initially (Because it is a Singleton by default)
            PokemonService pokeServ4 = container.getBean(PokemonService.class);
            PokemonService pokeServ5 = container.getBean(PokemonService.class);
            PokemonService pokeServ6 = container.getBean(PokemonService.class);


            Pokemon poke4 = container.getBean(Pokemon.class);
            Pokemon poke5 = container.getBean(Pokemon.class);
            Pokemon poke6 = container.getBean(Pokemon.class);

            poke4.setName("Pikachu");
            System.out.println(poke4.getName());
            poke5.setName("Ditto");
            System.out.println(poke5.getName());
            System.out.println(poke6.getName()); // empty or null or ...? Pikachu - 1, empty - 2

            System.out.println(poke6);

            
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
