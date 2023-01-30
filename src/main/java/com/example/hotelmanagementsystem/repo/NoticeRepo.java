package com.example.hotelmanagementsystem.repo;

import com.example.hotelmanagementsystem.entity.Blog;
import com.example.hotelmanagementsystem.entity.Notices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoticeRepo extends JpaRepository<Notices, Integer> {

    Optional<Notices> findNoticesByTopic(String topic);
}
