package com.example.hotelmanagementsystem.repo;

import com.example.hotelmanagementsystem.entity.Blog;
import com.example.hotelmanagementsystem.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Integer> {

    Optional<Blog> findBlogByTopic(String topic);
}
