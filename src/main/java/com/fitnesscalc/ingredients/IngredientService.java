package com.fitnesscalc.ingredients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    // Busca todos los ingredientes que existen
    public List<Ingredient> getIngredients() {
        return ingredientRepository.findAll();
    }

    // Nuevo ingrediente
    public Ingredient storeIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    // Modifica un ingrediente
    public Ingredient updateIngredient(Long id, Ingredient ingredient) {
        Optional<Ingredient> ingredientDb = ingredientRepository.findById(id);

        // Si no se encuentra lanza NoSuchElementException
        ingredientDb.orElseThrow();

        return ingredientRepository.save(ingredient);
    }

    // Elimina un ingrediente
    public Ingredient deleteIngredient(Long id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);

        // Si no se encuentra lanza NoSuchElementException
        ingredient.orElseThrow();

        // Borra el ingrediente
        ingredientRepository.deleteById(id);

        // Retorna el ingrediente borrado
        return ingredient.get();
    }
}
