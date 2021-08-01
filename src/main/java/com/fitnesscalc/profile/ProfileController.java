package com.fitnesscalc.profile;

import com.fitnesscalc.ingredients.Ingredient;
import com.fitnesscalc.user.User;
import com.fitnesscalc.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/v1/users/profile")
    public ProfileResponse index () {
        return profileService.getProfile();
    }

    @PostMapping("/api/v1/users/profile/weight")
    public Weight storeWeight (@RequestBody Weight weight) {
        return profileService.storeWeight(weight);
    }

    @PutMapping("/api/v1/users/profile")
    public Profile updateProfile (@RequestBody Profile profile) {
        return profileService.updateProfile(profile);
    }

    @PutMapping("/api/v1/users/goals")
    public Goal updateGoal (@RequestBody Goal goal) {
        return profileService.updateGoal(goal);
    }

}
