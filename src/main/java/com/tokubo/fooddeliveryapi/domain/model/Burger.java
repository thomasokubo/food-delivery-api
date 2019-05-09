package com.tokubo.fooddeliveryapi.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class Burger {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "burger")
    private List<Ingredient> ingredients;

    @Column(name = "is_permanent")
    private Boolean isPermanent;

    public Burger() {
    }

    public Burger(Builder builder) {
        Optional.ofNullable(builder.name).ifPresent(this::setName);
        Optional.ofNullable(builder.isPermanent).ifPresent(this::setIsPermanent);
        this.ingredients = builder.ingredients;
    }

    public static class Builder {
        private String name;
        private Boolean isPermanent;
        private List<Ingredient> ingredients = new ArrayList<>();

        public Builder() {
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withIngredients(List<Ingredient> ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public Builder withIsPermanent(Boolean isPermanent) {
            this.isPermanent = isPermanent;
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

    public List<Ingredient> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsPermanent() {
        return isPermanent;
    }

    public void setIsPermanent(Boolean permanent) {
        isPermanent = permanent;
    }
}
