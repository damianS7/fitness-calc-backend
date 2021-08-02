package com.fitnesscalc.profile;

import com.fitnesscalc.goals.Goal;
import com.fitnesscalc.meals.Meal;
import com.fitnesscalc.weights.Weight;

import java.util.HashMap;
import java.util.List;

public class ProfileResponse {
    private int age;
    private int height;


    public ProfileResponse() {
    }

//    public HashMap<String, Meal> getMeals() {
//        HashMap<String, Meal> map = new HashMap<String, Meal>();
//        for (Meal m : meals) {
//            map.put(m.getDate(), m);
//        }
//        return map;
//    }
//
//    public HashMap<String, Weight> getWeights() {
//        HashMap<String, Weight> map = new HashMap<String, Weight>();
//        for (Weight w : weights) {
//            map.put(w.getDate(), w);
//        }
//        return map;
//    }

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
