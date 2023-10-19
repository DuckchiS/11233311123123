package com.example.projectfinal.repository;

import com.example.projectfinal.model.entity.Predictions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredictionsRepository extends JpaRepository<Predictions, Integer> {
}
