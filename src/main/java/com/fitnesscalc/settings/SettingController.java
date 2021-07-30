package com.fitnesscalc.settings;

import com.fitnesscalc.ingredients.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class SettingController {
    @Autowired
    private SettingService settingService;

    @GetMapping("/api/v1/settings")
    public List<Setting> index () {
        return settingService.getSettings();
    }

    /**
     * Modifica una setting
     * @param key
     * @return Ingredient
     */
    @PutMapping("/api/v1/settings/{key}")
    public Setting updateSetting (@PathVariable String key,
                                        @RequestBody Setting setting) {
        return settingService.updateSetting(key, setting);
    }
}
