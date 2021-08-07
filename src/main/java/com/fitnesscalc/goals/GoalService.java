package com.fitnesscalc.goals;

import com.fitnesscalc.user.User;
import com.fitnesscalc.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private UserRepository userRepository;

    // Devuelve todas las metas del usuario
    public Goal getGoals() {
        // Usuario logeado
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        // Buscamos el usuario en la db o throw
        User user = userRepository.findByUsername((username)).orElseThrow();

        // Goals
        return goalRepository.findByUserId(user.getId()).orElseThrow();
    }

    // Modifica las metas de usuario
    public Goal updateGoal(Goal goalRequest) {
        // Usuario logeado
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        // Buscamos el usuario en la db o throw
        User user = userRepository.findByUsername((username)).orElseThrow();

        Goal goal = goalRepository.findByUserId(user.getId()).orElseThrow();

        // Modifica las metas de usuari
        goal.setCarbohydrates(goalRequest.getCarbohydrates());
        goal.setFats(goalRequest.getFats());
        goal.setKcal(goalRequest.getKcal());
        goal.setProteins(goalRequest.getProteins());

        // Guarda los cambios
        return goalRepository.save(goal);
    }
}
