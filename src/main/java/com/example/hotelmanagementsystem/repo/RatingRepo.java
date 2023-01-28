package com.example.hotelmanagementsystem.repo;

import com.example.hotelmanagementsystem.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Integer> {
}
