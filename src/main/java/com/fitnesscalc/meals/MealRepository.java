package com.fitnesscalc.meals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long>  {
    List<Meal> findByUserId(Long user_id);
    Optional<Meal> findByDate(String date);
}
