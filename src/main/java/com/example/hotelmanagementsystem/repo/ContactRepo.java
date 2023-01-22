package com.example.hotelmanagementsystem.repo;

import com.example.hotelmanagementsystem.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Integer> {
}
