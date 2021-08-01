package com.fitnesscalc.meals;

import java.util.HashMap;
import java.util.List;

public class MealsResponse {
    private List<Meal> meals;

    public MealsResponse(List<Meal> meals) {
        this.meals = meals;
    }

    public HashMap<String, Meal> getMeals() {
        HashMap<String, Meal> map = new HashMap<String, Meal>();
        for (Meal m : meals) {
            map.put(m.getDate(), m);
        }
        return map;
    }
}
