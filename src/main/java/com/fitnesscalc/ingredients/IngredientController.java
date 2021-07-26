package com.fitnesscalc.ingredients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/api/user/ingredients")
    public List<Ingredient> index () {
        return ingredientService.getIngredients();
    }

    @PostMapping("/api/user/ingredients")
    public Ingredient store (@RequestBody Ingredient ingredient) {
        return ingredient;
    }

}
