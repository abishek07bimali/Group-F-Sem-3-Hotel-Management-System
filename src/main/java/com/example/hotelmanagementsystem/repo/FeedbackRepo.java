package com.example.hotelmanagementsystem.repo;

import com.example.hotelmanagementsystem.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {
}
