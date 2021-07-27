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
     * @return List<Ingredient>
     */
    @GetMapping("/api/v1/ingredients")
    public List<Ingredient> getIngredients () {
        return ingredientService.getIngredients();
    }

    /**
     * Crea un nuevo ingrediente
     * @param ingredient
     * @return
     */
    @PostMapping("/api/v1/ingredients")
    public Ingredient storeIngredient (@RequestBody Ingredient ingredient) {
        return ingredientService.storeIngredient(ingredient);
    }

    /**
     * Modifica un ingrediente
     * @param id
     * @return Ingredient
     */
    @PutMapping("/api/v1/ingredients/{id}")
    public Ingredient updateIngredient (@PathVariable Long id,
                                        @RequestBody Ingredient ingredient) {
        return ingredientService.updateIngredient(id, ingredient);
    }

    /**
     * Borra un ingrediente
     * @param id
     * @return Ingredient
     */
    @DeleteMapping("/api/v1/ingredients/{id}")
    public Ingredient deleteIngredient (@PathVariable Long id) {
        return ingredientService.deleteIngredient(id);
    }
}
