package com.example.hotelmanagementsystem.repo;

import com.example.hotelmanagementsystem.entity.surprisePlanning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface surprisePlanningRepo extends JpaRepository<surprisePlanning, Integer> {
}