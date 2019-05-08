package com.tokubo.fooddeliveryapi.repository;

import com.tokubo.fooddeliveryapi.domain.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsRepository extends JpaRepository<Ingredient, Long> {
}
