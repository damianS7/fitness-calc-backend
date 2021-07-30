package com.fitnesscalc.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private WeightRepository weightRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private GoalRepository goalRepository;

    // Devuelve todas las comidas
    public ProfileResponse getProfile() {
        // user id
        Optional<Profile> profile = profileRepository.findByUserId(1L);

        // Con el profile_id buscamos el resto ...

        // Historial de pesos
        List<Weight> weights = weightRepository.findByProfileId(profile.get().getId());

        // Historial de comidas
        List<Meal> meals = mealRepository.findByProfileId(profile.get().getId());

        // Goals
        Optional<Goal> goal = goalRepository.findByProfileId(profile.get().getId());

        ProfileResponse response = new ProfileResponse();
        response.setAge(profile.get().getAge());
        response.setHeight(profile.get().getHeight());
        response.setWeights(weights);
        response.setGoals(goal.get());
        response.setMeals(meals);
        return response;
    }

    public Weight storeWeight(Weight weight) {
        // nuevo o actualizar existente!
        weightRepository.save(weight);
        return new Weight();
    }

    public Weight deleteWeight(String date) {
       return new Weight();
    }
}
