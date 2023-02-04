package com.example.hotelmanagementsystem.repo;

import com.example.hotelmanagementsystem.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {
    @Query(value = "SELECT * FROM booking where applied_user_id=?1", nativeQuery = true)
    List<Booking> findApplicationById(Integer id);
    Optional<Booking> findBookingByFullname(String fullname);
}
