package com.fitnesscalc.weights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping
public class WeightController {

    @Autowired
    private WeightService weightService;

    @GetMapping("/api/v1/user/weights")
    public HashMap<String, Weight> getWeights() {
        return weightService.getWeights();
    }

    @PostMapping("/api/v1/user/weight")
    public Weight storeWeight (@RequestBody Weight weight) {
        return weightService.storeWeight(weight);
    }
}
