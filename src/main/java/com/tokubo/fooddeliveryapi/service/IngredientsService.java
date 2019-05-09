package com.tokubo.fooddeliveryapi.service;

import com.tokubo.fooddeliveryapi.domain.model.Ingredient;
import com.tokubo.fooddeliveryapi.exception.NotFoundException;
import com.tokubo.fooddeliveryapi.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientsService {

    private final IngredientsRepository ingredientsRepository;

    @Autowired
    public IngredientsService(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    public List<Ingredient> findAll() {
        return ingredientsRepository.findAll();
    }

    public Ingredient findById(Long id) {
        return ingredientsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ingredient", id));
    }

    public Ingredient save(Ingredient ingredient) {
        return ingredientsRepository.save(ingredient);
    }
}
