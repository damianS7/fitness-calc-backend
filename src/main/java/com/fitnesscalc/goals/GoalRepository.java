package com.fitnesscalc.goals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long>  {
    Optional<Goal> findByUserId(Long user_id);
}
