package com.fitnesscalc.weights;

import com.fitnesscalc.profile.Profile;
import com.fitnesscalc.profile.ProfileResponse;
import com.fitnesscalc.profile.ProfileService;
import com.fitnesscalc.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class WeightController {

    @Autowired
    private WeightService weightService;

    @GetMapping("/api/v1/user/weights")
    public List<Weight> getWeights() {
        return weightService.getWeights();
    }

    @PostMapping("/api/v1/user/weight")
    public Weight storeWeight (@RequestBody Weight weight) {
        return weightService.storeWeight(weight);
    }

}
