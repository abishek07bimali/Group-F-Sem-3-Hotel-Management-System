package com.example.hotelmanagementsystem.repo;

import com.example.hotelmanagementsystem.entity.Blog;
import com.example.hotelmanagementsystem.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Integer> {
}
