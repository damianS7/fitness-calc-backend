package com.fitnesscalc.meals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateMealRequest {
    private String date;
    private String meal;
    private int foodId;

    public UpdateMealRequest(String date, String meal, int foodId) {
        this.date = date;
        this.meal = meal;
        this.foodId = foodId;
    }

    public String getDate() {
        return date;
    }

    public String getMeal() {
        return meal;
    }

    public int getFoodId() {
        return foodId;
    }
}
