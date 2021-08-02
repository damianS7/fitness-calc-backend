package com.fitnesscalc.meals;

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

    public Meal addFood(UpdateMealRequest request) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername((username)).orElseThrow();

        Date d = null;
        try {
            d = new SimpleDateFormat("yyyy-MM-dd").parse(request.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Meal meal = mealRepository.findByDate(d).orElseThrow();

//        if(request.getMeal()) {
//
//        }

        meal.getMeal1().add(request.getFoodId());

        return mealRepository.save(meal);
    }


    public Meal deleteFood(UpdateMealRequest request) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername((username)).orElseThrow();
        Date d = null;
        try {
            d = new SimpleDateFormat("yyyy-MM-dd").parse(request.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Meal meal = mealRepository.findByDate(d).orElseThrow();
        meal.getMeal1().remove(request.getFoodId());
        return mealRepository.save(meal);
    }
}
