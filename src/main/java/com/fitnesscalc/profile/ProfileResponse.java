package com.fitnesscalc.profile;

import com.fitnesscalc.meals.Meal;

import java.util.HashMap;
import java.util.List;

public class ProfileResponse {
    private List<Weight> weights;
    private List<Meal> meals;
    private Goal goals;
    private int age;
    private int height;


    public ProfileResponse() {
    }

    public Goal getGoals() {
        return goals;
    }

    public void setGoals(Goal goals) {
        this.goals = goals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public HashMap<String, Meal> getMeals() {
        HashMap<String, Meal> map = new HashMap<String, Meal>();
        for (Meal m : meals) {
            map.put(m.getDate(), m);
        }
        return map;
    }


    public HashMap<String, Weight> getWeights() {
        HashMap<String, Weight> map = new HashMap<String, Weight>();
        for (Weight w : weights) {
            map.put(w.getDate(), w);
        }
        return map;
    }

    public void setWeights(List<Weight> weights) {
        this.weights = weights;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

}
