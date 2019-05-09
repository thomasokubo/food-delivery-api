package com.tokubo.fooddeliveryapi.controller;

import com.tokubo.fooddeliveryapi.domain.model.Burger;
import com.tokubo.fooddeliveryapi.service.BurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/burgers")
public class BurgerController {

    private final BurgerService burgerService;

    @Autowired
    public BurgerController(BurgerService burgerService) {
        this.burgerService = burgerService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Burger>> findAllBurgers() {
        return new ResponseEntity<>(burgerService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Burger> findBurgerById(@PathVariable final Long id) throws RuntimeException {
        Burger burger = burgerService.findById(id);
        return new ResponseEntity<>(burger, HttpStatus.OK);
    }
}
