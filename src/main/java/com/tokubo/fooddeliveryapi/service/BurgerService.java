package com.tokubo.fooddeliveryapi.service;

import com.tokubo.fooddeliveryapi.domain.model.Burger;
import com.tokubo.fooddeliveryapi.exception.NotFoundException;
import com.tokubo.fooddeliveryapi.repository.BurgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BurgerService {

    private final BurgerRepository burgerRepository;

    @Autowired
    public BurgerService(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }

    public List<Burger> findAll() {
        return burgerRepository.findAll();
    }

    public Burger findById(Long id) {
        return burgerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Burger", id));
    }

    public Burger save(Burger burger) {
        return burgerRepository.save(burger);
    }
}
