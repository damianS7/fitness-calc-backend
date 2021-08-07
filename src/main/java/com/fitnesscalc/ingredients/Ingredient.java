package com.fitnesscalc.ingredients;


import javax.persistence.*;

@Entity
@Table(name="ingredients")
public class Ingredient {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int proteins;

    @Column
    private int fats;

    @Column
    private int carbohydrates;

    public Ingredient() {}

    public Ingredient(Long id, String name, int proteins, int fats, int carbohydrates) {
        this.id = id;
        this.name = name;
        this.fats = fats;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
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

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }
}
