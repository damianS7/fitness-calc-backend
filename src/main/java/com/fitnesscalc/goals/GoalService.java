package com.fitnesscalc.goals;

import com.fitnesscalc.meals.Meal;
import com.fitnesscalc.meals.MealRepository;
import com.fitnesscalc.profile.Profile;
import com.fitnesscalc.profile.ProfileRepository;
import com.fitnesscalc.profile.ProfileResponse;
import com.fitnesscalc.user.User;
import com.fitnesscalc.user.UserRepository;
import com.fitnesscalc.weights.Weight;
import com.fitnesscalc.weights.WeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private UserRepository userRepository;

    // Devuelve todas las comidas
    public Goal getGoals() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername((username)).orElseThrow();

        // Goals
        return goalRepository.findByUserId(user.getId()).orElseThrow();
    }

    public Goal updateGoal(Goal goalRequest) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername((username)).orElseThrow();

//        Optional<Goal> optionalGoal = goalRepository.findByProfileId(storedProfile.getId());
        Goal goal = goalRepository.findByUserId(user.getId()).orElseThrow();
        goal.setCarbohydrates(goalRequest.getCarbohydrates());
        goal.setFats(goalRequest.getFats());
        goal.setKcal(goalRequest.getKcal());
        goal.setProteins(goalRequest.getProteins());
        return goalRepository.save(goal);
    }
}
