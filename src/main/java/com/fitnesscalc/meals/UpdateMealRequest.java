package com.fitnesscalc.meals;

public class UpdateMealRequest {
    private String date;
    private String meal;
    private int ingredient;

    public UpdateMealRequest(String date, String meal, int ingredient) {
        this.date = date;
        this.meal = meal;
        this.ingredient = ingredient;
    }

    public String getDate() {
        return date;
    }

    public String getMeal() {
        return meal;
    }
}
