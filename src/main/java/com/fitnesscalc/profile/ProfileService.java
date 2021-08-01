package com.fitnesscalc.profile;

import com.fitnesscalc.meals.Meal;
import com.fitnesscalc.meals.MealRepository;
import com.fitnesscalc.user.User;
import com.fitnesscalc.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    private UserRepository userRepository;

    // Devuelve todas las comidas
    public ProfileResponse getProfile() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User u = userRepository.findByUsername((username)).orElseThrow();
        // user id
        Optional<Profile> profile = profileRepository.findByUserId(u.getId());

        // Con el profile_id buscamos el resto ...

        // Historial de pesos
        List<Weight> weights = weightRepository.findByProfileId(profile.get().getId());

        // Historial de comidas
        List<Meal> meals = mealRepository.findByUserId(u.getId());

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
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> u = userRepository.findByUsername((username));
        Optional<Profile> p = profileRepository.findByUserId(u.get().getId());

        // Buscamos un peso con la misma fecha y del mismo perfil
        List<Weight> weights = weightRepository.findByProfileId(p.get().getId());
        for (Weight w : weights ) {
            if(w.getDate().equals(weight.getDate())) {
                w.setWeight(weight.getWeight());
                return weightRepository.save(w);
            }
        }


        // Agregamos el id del perfil de usuario
        weight.setProfileId(p.get().getId());

        // nuevo o actualizar existente!

        return weightRepository.save(weight);
    }

    public Profile updateProfile(Profile profile) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> user = userRepository.findByUsername((username));
        Optional<Profile> optionalProfile = profileRepository.findByUserId(user.get().getId());

        optionalProfile.orElseThrow();

        Profile storedProfile = optionalProfile.get();

        storedProfile.setAge(profile.getAge());
        storedProfile.setHeight(profile.getHeight());
        return profileRepository.save(storedProfile);
    }

    public Goal updateGoal(Goal goalRequest) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> user = userRepository.findByUsername((username));
        Optional<Profile> optionalProfile = profileRepository.findByUserId(user.get().getId());

        optionalProfile.orElseThrow();

        Profile storedProfile = optionalProfile.get();
//        Optional<Goal> optionalGoal = goalRepository.findByProfileId(storedProfile.getId());
        Goal goal = goalRepository.findByProfileId(storedProfile.getId()).orElseThrow();
        goal.setCarbohydrates(goalRequest.getCarbohydrates());
        goal.setFats(goalRequest.getFats());
        goal.setKcal(goalRequest.getKcal());
        goal.setProteins(goalRequest.getProteins());
        return goalRepository.save(goal);
    }
}
