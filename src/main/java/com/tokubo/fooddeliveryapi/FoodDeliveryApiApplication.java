package com.tokubo.fooddeliveryapi;

import com.tokubo.fooddeliveryapi.domain.model.Burger;
import com.tokubo.fooddeliveryapi.domain.model.Ingredient;
import com.tokubo.fooddeliveryapi.service.BurgerService;
import com.tokubo.fooddeliveryapi.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class FoodDeliveryApiApplication {

	@Autowired
	private BurgerService burgerService;

	@Autowired
	private IngredientsService ingredientsService;

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Populating database");
            Burger xBurger= new Burger();
            xBurger.setName("X-Burger");
            burgerService.save(xBurger);
            ingredientsService.save(new Ingredient("Hamburger", 3.0, xBurger));
            ingredientsService.save(new Ingredient("Cheese", 1.5, xBurger));

            Burger xBacon= new Burger();
            xBacon.setName("X-Bacon");
            burgerService.save(xBacon);
            ingredientsService.save(new Ingredient("Bacon", 2.0, xBacon));
            ingredientsService.save(new Ingredient("Hamburger", 3.0, xBacon));
            ingredientsService.save(new Ingredient("Cheese", 1.5, xBacon));

            Burger xEgg= new Burger();
            xEgg.setName("X-Egg");
            burgerService.save(xEgg);
            ingredientsService.save(new Ingredient("Hamburger", 3.0, xEgg));
            ingredientsService.save(new Ingredient("Egg", 0.8, xEgg));
            ingredientsService.save(new Ingredient("Cheese", 1.5, xEgg));

            Burger xEggBacon= new Burger();
            xEgg.setName("X-EggBacon");
            burgerService.save(xEggBacon);
            ingredientsService.save(new Ingredient("Bacon", 2.0, xEggBacon));
            ingredientsService.save(new Ingredient("Hamburger", 3.0, xEggBacon));
            ingredientsService.save(new Ingredient("Egg", 0.8, xEggBacon));
            ingredientsService.save(new Ingredient("Cheese", 1.5, xEggBacon));
            
			System.out.println("Finished populating");
		};
	}

}
