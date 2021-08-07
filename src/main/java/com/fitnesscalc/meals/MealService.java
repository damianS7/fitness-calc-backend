package com.fitnesscalc.meals;

import com.fitnesscalc.auth.AuthenticationFailedException;
import com.fitnesscalc.user.User;
import com.fitnesscalc.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private UserRepository userRepository;

    public MealsResponse getMeals() {
        // Usuario logeado
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        // Buscamos el usuario en la db o throw
        User user = userRepository.findByUsername((username)).orElseThrow();

        // Buscamos las meals correspondientes al usuario
        List<Meal> meals = mealRepository.findByUserId(user.getId());

        return new MealsResponse(meals);
    }

    /**
     * Modifica una comida
     * @param request
     * @return
     */
    public Meal updateMeal(Meal request) {
        // Usuario logeado
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        // Buscamos el usuario que hace la peticion y lanzamos error si no existe.
        User user = userRepository.findByUsername((username)).orElseThrow();

        // Si no tiene id la peticion, crearemos una nueva
        if(request.getId() == null) {
            request.setUserId(user.getId());
            return mealRepository.save(request);
        }

        // Si tiene un id lo buscamos
        Meal meal = mealRepository.findById(request.getId()).orElseThrow();

        // Si lo encontramos, vamos realizamos comprobaciones antes de
        // de modificar comprobamos que pertenece al usuario
        if(!meal.getUserId().equals(user.getId())) {
            throw new AuthenticationFailedException("");
        }

        // Asignamos los nuevos valores
        meal.setMeal1(request.getMeal1());
        meal.setMeal2(request.getMeal2());
        meal.setMeal3(request.getMeal3());
        meal.setMeal4(request.getMeal4());
        meal.setMeal5(request.getMeal5());

        // Guardamos los cambios
        return mealRepository.save(meal);
    }
}
