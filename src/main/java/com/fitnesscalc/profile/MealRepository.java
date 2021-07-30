package com.fitnesscalc.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long>  {
    List<Meal> findByProfileId(Long profile_id);
}
