package com.example.hotelmanagementsystem.repo;

import com.example.hotelmanagementsystem.entity.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleryRepo extends JpaRepository<Gallery, Integer> {
}
