package com.example.hotelmanagementsystem.repo;

import com.example.hotelmanagementsystem.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {
//    @Query(value = "select * from booking where booking.id=:bookingId", nativeQuery = true)
//    Page<Booking> pagination(@Param("bookingId")  Pageable pageable);
}
