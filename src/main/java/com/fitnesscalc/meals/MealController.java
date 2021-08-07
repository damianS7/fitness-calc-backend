package com.fitnesscalc.meals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MealController {

    @Autowired private MealService mealService;

    @GetMapping("/api/v1/user/meals")
    public MealsResponse getMeals() {
        return mealService.getMeals();
    }

    @PutMapping("/api/v1/user/meal")
    public Meal updateMeal (@RequestBody Meal request) {
        return mealService.updateMeal(request);
    }

}
