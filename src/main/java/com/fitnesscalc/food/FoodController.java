package com.fitnesscalc.food;

import com.fitnesscalc.ingredients.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/api/user/foods")
    public List<Food> index () {
        return foodService.getFoods();
    }

    @PostMapping("/api/user/foods")
    public Food store (@RequestBody Food food) {
        return food;
    }

}
