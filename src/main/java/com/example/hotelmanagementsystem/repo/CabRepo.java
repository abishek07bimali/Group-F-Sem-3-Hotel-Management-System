package com.example.hotelmanagementsystem.repo;

import com.example.hotelmanagementsystem.entity.Booking;
import com.example.hotelmanagementsystem.entity.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface CabRepo extends JpaRepository<Cab,Integer> {

    Optional<Cab> findCabByFullname(String fullname);
}
