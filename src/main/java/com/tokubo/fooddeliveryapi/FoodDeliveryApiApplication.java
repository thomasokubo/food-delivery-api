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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
			Ingredient lettuce = new Ingredient("Lettuce", 0.4);
			Ingredient bacon = new Ingredient("Bacon", 2.0);
			Ingredient hamburger = new Ingredient("Hamburger", 3.0);
			Ingredient egg = new Ingredient("Egg", 0.8);
			Ingredient cheese = new Ingredient("Cheese", 1.5);
			ingredientsService.save(lettuce);
			ingredientsService.save(bacon);
			ingredientsService.save(hamburger);
			ingredientsService.save(egg);
			ingredientsService.save(cheese);

			Burger xBacon = new Burger.Builder()
					.withName("X-Bacon")
					.withIngredients(Arrays.asList(bacon, hamburger, cheese))
					.withIsPermanent(true)
					.build();

			Burger xBurger = new Burger.Builder()
					.withName("X-Burger")
					.withIngredients(Arrays.asList(hamburger, cheese))
					.withIsPermanent(true)
					.build();

			Burger xEgg = new Burger.Builder()
					.withName("X-Egg")
					.withIngredients(Arrays.asList(egg, hamburger, cheese))
					.withIsPermanent(true)
					.build();

			Burger xEggBacon = new Burger.Builder()
					.withName("X-EggBacon")
					.withIngredients(Arrays.asList(egg, bacon, hamburger, cheese))
					.withIsPermanent(true)
					.build();

			burgerService.save(xBurger);
			burgerService.save(xBacon);
			burgerService.save(xEgg);
			burgerService.save(xEggBacon);

		};
	}

}
