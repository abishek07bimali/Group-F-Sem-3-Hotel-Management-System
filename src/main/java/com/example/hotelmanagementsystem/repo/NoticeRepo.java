package com.example.hotelmanagementsystem.repo;

import com.example.hotelmanagementsystem.entity.Notices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepo extends JpaRepository<Notices, Integer> {
}
