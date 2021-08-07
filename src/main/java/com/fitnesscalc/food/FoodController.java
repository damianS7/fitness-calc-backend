package com.fitnesscalc.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class FoodController {
    @Autowired
    private FoodService foodService;

    /**
     * Devuelve todos las comidas
     *
     * @return List<Food>
     */
    @GetMapping("/api/v1/foods")
    public List<Food> index() {
        return foodService.getFoods();
    }

    /**
     * Crea una nueva comida
     * @param food
     * @return
     */
    @PostMapping("/api/v1/foods")
    public Food storeFood(@RequestBody Food food) {
        return foodService.storeFood(food);
    }

    /**
     * Modifica una comida
     * @param id
     * @return Food
     */
    @PutMapping("/api/v1/foods/{id}")
    public Food updateFood(@PathVariable Long id,
                                 @RequestBody Food food) {
        return foodService.updateFood(id, food);
    }

    /**
     * Borra una comida
     * @param id
     * @return Food
     */
    @DeleteMapping("/api/v1/foods/{id}")
    public Food deleteFood(@PathVariable Long id) {
        return foodService.deleteFood(id);
    }
}
