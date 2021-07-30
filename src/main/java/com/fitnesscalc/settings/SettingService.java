package com.fitnesscalc.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SettingService {

    @Autowired
    private SettingRepository settingRepository;

    public List<Setting> getSettings() {
        return settingRepository.findAll();
    }

    // Modifica un ingrediente
    public Setting updateSetting(String key, Setting setting) {
        Optional<Setting> settingOp = settingRepository.findById(key);

        // Si no se encuentra lanza NoSuchElementException
        settingOp.orElseThrow();


        return settingRepository.save(setting);
    }
}
