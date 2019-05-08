package com.tokubo.fooddeliveryapi.controller;

import com.tokubo.fooddeliveryapi.domain.model.Ingredient;
import com.tokubo.fooddeliveryapi.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    private final IngredientsService ingredientsService;

    @Autowired
    public IngredientController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Ingredient>> findAllIngredients() {
        return new ResponseEntity<>(ingredientsService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Ingredient> findIngredientById(@PathVariable Long id) throws RuntimeException{
        Ingredient ingredient = ingredientsService.findById(id);
        return new ResponseEntity<>(ingredient, HttpStatus.OK);
    }
}
