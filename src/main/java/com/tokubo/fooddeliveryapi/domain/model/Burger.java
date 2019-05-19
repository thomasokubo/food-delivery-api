package com.tokubo.fooddeliveryapi.domain.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="burger")
public class Burger {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "burger", cascade=CascadeType.ALL)
    private Set<Ingredient> ingredients;

    public Burger() {
    }

    public Burger(Builder builder) {
        Optional.ofNullable(builder.name).ifPresent(this::setName);
        this.ingredients = builder.ingredients;
    }

    public static class Builder {
        private String name;
        private Set<Ingredient> ingredients = new HashSet<>();

        public Builder() {
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withIngredients(Set<Ingredient> ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public Burger build() {
            return new Burger(this);
        }
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

    public Set<Ingredient> getIngredients() {
        return new HashSet<>(ingredients);
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
