package com.fitnesscalc.ingredients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Ingredient updateIngredient(Long id, Ingredient requestIngredient) {
        // Si no se encuentra lanza NoSuchElementException
        Ingredient ingredient = ingredientRepository.findById(id).orElseThrow();

        // Modificamos el ingrediente
        ingredient.setName(requestIngredient.getName());
        ingredient.setProteins(requestIngredient.getProteins());
        ingredient.setFats(requestIngredient.getFats());
        ingredient.setCarbohydrates(requestIngredient.getCarbohydrates());

        // Guardamos los cambios
        return ingredientRepository.save(ingredient);
    }

    // Elimina un ingrediente
    public Ingredient deleteIngredient(Long id) {
        // Si no se encuentra lanza NoSuchElementException
        Ingredient ingredient = ingredientRepository.findById(id).orElseThrow();

        // Borra el ingrediente
        ingredientRepository.deleteById(id);

        // Retorna el ingrediente borrado
        return ingredient;
    }
}
