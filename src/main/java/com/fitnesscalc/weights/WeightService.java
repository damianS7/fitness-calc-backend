package com.fitnesscalc.weights;

import com.fitnesscalc.user.User;
import com.fitnesscalc.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class WeightService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeightRepository weightRepository;

    /**
     * Devuelve todos los pesos pertenecientes a un usuario
     * @return
     */
    public HashMap<String, Weight> getWeights() {
        // Usuario de la peticion
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        // Entidad del usuario
        User user = userRepository.findByUsername((username)).orElseThrow();

        // Lista con los pesos
        List<Weight> weightList = weightRepository.findByUserId(user.getId());

        // Historial de pesos
        HashMap<String, Weight> weightMap = new HashMap<String, Weight>();
        for (Weight weight : weightList) {
            weightMap.put(this.dateToString(weight.getDate()), weight);
        }

        return weightMap;
    }

    /**
     * Agrega un peso nuevo o modifica uno ya existente
     * @param weightRequest
     * @return
     */
    public Weight storeWeight(Weight weightRequest) {
        // Usuario logeado
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        // Entidad del usuario
        User user = userRepository.findByUsername((username)).orElseThrow();

        // Buscamos un peso de este usuario y con la fecha enviada
        Optional<Weight> weight = weightRepository.findByUserIdAndDate(user.getId(), weightRequest.getDate());

        // Si existe un peso ...
        if(weight.isPresent()) {
            // En caso de existir, asignamos el peso de la peticion
            weight.get().setWeight(weightRequest.getWeight());
            return weightRepository.save(weight.get());
        }

        // Si no existe agregamos uno nuevo
        weightRequest.setUserId(user.getId());

        // Guardamos el nuevo peso
        return weightRepository.save(weightRequest);
    }

    private String dateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
}
