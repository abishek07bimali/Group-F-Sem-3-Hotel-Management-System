package com.example.hotelmanagementsystem.repo;

import com.example.hotelmanagementsystem.entity.Blog_Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Blog_Comment,Integer> {
}
