package com.fitnesscalc.food;

import com.fitnesscalc.ingredients.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;

    // Devuelve todas las comidas
    public List<Food> getFoods() {
        return foodRepository.findAll();
    }

    // Nueva comida
    public Food storeFood(Food food) {
        return foodRepository.save(food);
    }

    // Modifica una comida
    public Food updateFood(Long id, Food food) {
        Optional<Food> ingredientDb = foodRepository.findById(id);

        // Si no se encuentra lanza NoSuchElementException
        ingredientDb.orElseThrow();

        return foodRepository.save(food);
    }

    // Elimina una comida
    public Food deleteFood(Long id) {
        Optional<Food> food = foodRepository.findById(id);

        // Si no se encuentra lanza NoSuchElementException
        food.orElseThrow();

        // Borra la comida
        foodRepository.deleteById(id);

        // Retorna la comida borrada
        return food.get();
    }
}
