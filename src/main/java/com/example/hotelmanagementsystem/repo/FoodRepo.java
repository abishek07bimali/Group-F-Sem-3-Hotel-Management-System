package com.example.hotelmanagementsystem.repo;

import com.example.hotelmanagementsystem.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepo extends JpaRepository<Food,Integer> {
}
