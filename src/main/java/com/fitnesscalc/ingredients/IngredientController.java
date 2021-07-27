package com.fitnesscalc.ingredients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    /**
     * Devuelve todos los ingredientes
     * @return
     */
    @GetMapping("/api/user/ingredients")
    public List<Ingredient> getIngredients () {
        return ingredientService.getIngredients();
    }

    /**
     * Crea un nuevo ingrediente
     * @param ingredient
     * @return
     */
    @PostMapping("/api/user/ingredients")
    public Ingredient storeIngredient (@RequestBody Ingredient ingredient) {
        return ingredientService.storeIngredient(ingredient);
    }

    /**
     * Modifica un ingrediente
     * @param ingredientId
     * @return Ingredient
     */
    @PutMapping("/api/user/ingredients/{ingredientId}")
    public Ingredient updateIngredient (@PathVariable Long ingredientId,
                                        @RequestBody Ingredient ingredient) {
        return ingredientService.updateIngredient(ingredient);
    }

    /**
     * Borra un ingrediente
     * @param ingredientId
     * @return Ingredient
     */
    @DeleteMapping("/api/user/ingredients/{ingredientId}")
    public Ingredient deleteIngredient (@PathVariable Long ingredientId) {
        return ingredientService.deleteIngredient(ingredientId);
    }
}
