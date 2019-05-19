package com.tokubo.fooddeliveryapi.domain.model;

import javax.persistence.*;

@Entity
@Table(name="ingredient")
public class Ingredient {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "burger_id")
    private Burger burger;

    public Ingredient() {
    }

    public Ingredient(String name, Double price, Burger burger) {
        this.name = name;
        this.price = price;
        this.burger = burger;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
