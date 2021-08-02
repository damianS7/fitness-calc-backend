package com.fitnesscalc.profile;

import com.fitnesscalc.user.User;
import com.fitnesscalc.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;

    // Devuelve todas las comidas
    public ProfileResponse getProfile() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername((username)).orElseThrow();
        // user id
        Profile profile = profileRepository.findByUserId(user.getId()).orElseThrow();

        // Con el profile_id buscamos el resto ...


        ProfileResponse response = new ProfileResponse();
        response.setAge(profile.getAge());
        response.setHeight(profile.getHeight());
        return response;
    }

    public Profile updateProfile(Profile profile) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername((username)).orElseThrow();
        Optional<Profile> optionalProfile = profileRepository.findByUserId(user.getId());

        optionalProfile.orElseThrow();

        Profile storedProfile = optionalProfile.get();

        storedProfile.setAge(profile.getAge());
        storedProfile.setHeight(profile.getHeight());
        return profileRepository.save(storedProfile);
    }

}
