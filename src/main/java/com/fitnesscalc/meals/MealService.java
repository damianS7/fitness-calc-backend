package com.fitnesscalc.meals;

import com.fitnesscalc.profile.*;
import com.fitnesscalc.user.User;
import com.fitnesscalc.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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


    public Meal updateMeal(UpdateMealRequest request) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername((username)).orElseThrow();
        Meal meal = mealRepository.findByDate(request.getDate()).orElseThrow();

//        return mealRepository.save(meal);
        return meal;
    }
}
