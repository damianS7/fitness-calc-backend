package com.fitnesscalc.goals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class GoalController {

    @Autowired
    private GoalService goalService;

    @GetMapping("/api/v1/user/goals")
    public Goal getGoals () {
        return goalService.getGoals();
    }

    @PutMapping("/api/v1/user/goal")
    public Goal updateGoal (@RequestBody Goal goal) {
        return goalService.updateGoal(goal);
    }
}
