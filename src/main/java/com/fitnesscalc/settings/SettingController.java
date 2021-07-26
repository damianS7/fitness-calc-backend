package com.fitnesscalc.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class SettingController {
    @Autowired
    private SettingService settingService;

    @GetMapping("/api/user/settings")
    public List<Setting> index () {
        return settingService.getSettings();
    }

    @PostMapping("/api/user/settings")
    //    @PutMapping
    public String update () {
        return "";
    }
}
