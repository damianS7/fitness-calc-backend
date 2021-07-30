package com.fitnesscalc.profile;

import com.fitnesscalc.ingredients.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/api/v1/users/profile")
    public ProfileResponse index () {
        return profileService.getProfile();
    }

    @PostMapping("/api/v1/users/profile/weight")
    public Weight storeWeight (@RequestBody Weight weight) {
        return profileService.storeWeight(weight);
    }

    /**
     * Borra un peso
     * @param date del Peso a borrar
     * @return Weight El peso borrado
     */
    @DeleteMapping("/api/v1/users/profile/weight/{id}")
    public Weight deleteWeight (@PathVariable String date) {
        return profileService.deleteWeight(date);
    }

}
