package com.fitnesscalc.weights;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface WeightRepository extends JpaRepository<Weight, Long>  {
    List<Weight> findByUserId(Long userId);
    Optional<Weight> findByUserIdAndDate(Long id, Date date);
}
