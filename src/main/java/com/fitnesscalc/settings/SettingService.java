package com.fitnesscalc.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingService {

    @Autowired
    private SettingRepository settingRepository;

    public List<Setting> getSettings() {
        return settingRepository.findAll();
    }
}