package com.tokubo.fooddeliveryapi.repository;

import com.tokubo.fooddeliveryapi.domain.model.Burger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BurgerRepository extends JpaRepository<Burger, Long> {
}
