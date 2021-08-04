package com.fitnesscalc.meals;

import java.util.List;

public class MealRequest {
    private Long id;
    private String date;
    private List<Integer> meal1;
    private List<Integer> meal2;
    private List<Integer> meal3;
    private List<Integer> meal4;
    private List<Integer> meal5;

    public MealRequest(Long id, String date, List<Integer> meal1, List<Integer> meal2,
        List<Integer> meal3, List<Integer> meal4,List<Integer> meal5) {
        this.id = id;
        this.date = date;
        this.meal1 = meal1;
        this.meal2 = meal2;
        this.meal3 = meal3;
        this.meal4 = meal4;
        this.meal5 = meal5;
    }

    public String getDate() {
        return date;
    }

    public Long getId() {
        return id;
    }

    public List<Integer> getMeal5() {
        return meal5;
    }

    public List<Integer> getMeal3() {
        return meal3;
    }

    public List<Integer> getMeal4() {
        return meal4;
    }

    public List<Integer> getMeal2() {
        return meal2;
    }

    public List<Integer> getMeal1() {
        return meal1;
    }
}
