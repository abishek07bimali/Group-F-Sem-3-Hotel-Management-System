package com.example.hotelmanagementsystem.repo;

import com.example.hotelmanagementsystem.entity.Booking;
import com.example.hotelmanagementsystem.entity.surprisePlanning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface surprisePlanningRepo extends JpaRepository<surprisePlanning, Integer> {

//    Optional<surprisePlanning> findsurprisePlanningBy(String startdate);
}