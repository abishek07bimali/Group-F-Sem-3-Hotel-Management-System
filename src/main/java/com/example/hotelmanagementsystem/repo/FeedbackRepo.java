package com.example.hotelmanagementsystem.repo;

import com.example.hotelmanagementsystem.entity.Contact;
import com.example.hotelmanagementsystem.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {

    Optional<Feedback> findFeedbackByEmail(String email);
}
