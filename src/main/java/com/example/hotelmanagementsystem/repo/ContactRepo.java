package com.example.hotelmanagementsystem.repo;

import com.example.hotelmanagementsystem.entity.Booking;
import com.example.hotelmanagementsystem.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Integer> {

    Optional<Contact> findContactByEmail(String email);
}
