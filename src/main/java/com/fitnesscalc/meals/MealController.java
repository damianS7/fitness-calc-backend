package com.fitnesscalc.meals;

import com.fitnesscalc.profile.*;
import com.fitnesscalc.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MealController {

    @Autowired private MealService mealService;

    @GetMapping("/api/v1/user/meals")
    public MealsResponse getMeals() {
        return mealService.getMeals();
    }

    @PostMapping("/api/v1/user/meal")
    public Meal updateMeal (@RequestBody MealRequest request) {
        return mealService.updateMeal(request);
    }

}
