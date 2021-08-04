package com.fitnesscalc.meals;

import com.fitnesscalc.auth.AuthenticationFailedException;
import com.fitnesscalc.profile.*;
import com.fitnesscalc.user.User;
import com.fitnesscalc.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private UserRepository userRepository;

    public MealsResponse getMeals() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername((username)).orElseThrow();
        List<Meal> meals = mealRepository.findByUserId(user.getId());

        return new MealsResponse(meals);
    }

    public Meal updateMeal(MealRequest request) {
        System.out.println(request.getDate());
        System.out.println(request.getMeal1());
        System.out.println(request.getMeal2());
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        // Buscamos el usuario que hace la peticion y lanzamos error si no existe.
        User user = userRepository.findByUsername((username)).orElseThrow();

        // Si no tiene id la peticion, crearemos una nueva
        if(request.getId() == null) {
            Date newDate = null;
            try {
                newDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Meal newMeal = new Meal(
                    null, user.getId(), newDate,
                    request.getMeal1(), request.getMeal2(), request.getMeal3(),
                    request.getMeal4(), request.getMeal5()
            );
            return mealRepository.save(newMeal);
        }

        // Si tiene un id lo buscamos
        Optional<Meal> meal = mealRepository.findById(request.getId());

        // Si no existe cramos una nueva comida
        if(!meal.isPresent()) {
            throw new AuthenticationFailedException("");
        }

        // Si lo encontramos, vamos realizamos comprobaciones antes de
        // de modificar comprobamos que pertenece al usuario
        if(!meal.get().getUserId().equals(user.getId())) {
            throw new AuthenticationFailedException("");
        }

        meal.get().setMeal1(request.getMeal1());
        meal.get().setMeal2(request.getMeal2());
        meal.get().setMeal3(request.getMeal3());
        meal.get().setMeal4(request.getMeal4());
        meal.get().setMeal5(request.getMeal5());

        // Guardamos los cambios
        return mealRepository.save(meal.get());
    }
}
