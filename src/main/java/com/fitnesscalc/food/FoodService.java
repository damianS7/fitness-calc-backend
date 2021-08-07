package com.fitnesscalc.food;

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
    public Food updateFood(Long id, Food request) {
        // Si no se encuentra lanza NoSuchElementException
        Food food = foodRepository.findById(id).orElseThrow();

        // Modificamos la comida
        food.setName(request.getName());
        food.setIngredients(request.getIngredients());

        // Guardamos los cambios
        return foodRepository.save(food);
    }

    // Elimina una comida
    public Food deleteFood(Long id) {
        // Si no se encuentra lanza NoSuchElementException
        Food food = foodRepository.findById(id).orElseThrow();

        // Borra la comida
        foodRepository.deleteById(id);

        // Retorna la comida borrada
        return food;
    }
}
