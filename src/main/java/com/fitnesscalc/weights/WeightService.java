package com.fitnesscalc.weights;

import com.fitnesscalc.goals.Goal;
import com.fitnesscalc.meals.Meal;
import com.fitnesscalc.profile.Profile;
import com.fitnesscalc.profile.ProfileResponse;
import com.fitnesscalc.user.User;
import com.fitnesscalc.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeightService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeightRepository weightRepository;

    // Devuelve todas las comidas
    public List<Weight> getWeights() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername((username)).orElseThrow();

        // Historial de pesos
        List<Weight> weights = weightRepository.findByUserId(user.getId());


        return weights;
    }

    public Weight storeWeight(Weight weight) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername((username)).orElseThrow();

        // Buscamos un peso con la misma fecha y del mismo perfil
        List<Weight> weights = weightRepository.findByUserId(user.getId());
        for (Weight w : weights ) {
            if(w.getDate().equals(weight.getDate())) {
                w.setWeight(weight.getWeight());
                return weightRepository.save(w);
            }
        }


        // Agregamos el id del perfil de usuario
        weight.setUserId(user.getId());

        // nuevo o actualizar existente!

        return weightRepository.save(weight);
    }
}
