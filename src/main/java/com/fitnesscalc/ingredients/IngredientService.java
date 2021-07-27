package com.fitnesscalc.ingredients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    public List<Ingredient> getIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient storeIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public Ingredient updateIngredient(Ingredient ingredient) {
//        Ingredient i = ingredientRepository.findById(ingredient.getId());
//        ingredientRepository.flush();
        return ingredientRepository.save(ingredient);
    }

    public Ingredient deleteIngredient(Long ingredientId) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(ingredientId);
        ingredientRepository.deleteById(ingredientId);
        return ingredient.orElse(null);
    }
}
