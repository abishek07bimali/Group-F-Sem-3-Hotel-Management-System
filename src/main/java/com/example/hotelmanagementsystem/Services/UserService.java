package com.example.hotelmanagementsystem.Services;


import com.example.hotelmanagementsystem.UserPojo.BookingPojo;
import com.example.hotelmanagementsystem.UserPojo.LaundaryPojo;
import com.example.hotelmanagementsystem.UserPojo.UserPojo;
import com.example.hotelmanagementsystem.entity.Booking;
import com.example.hotelmanagementsystem.entity.Laundary;


import java.util.List;

public interface UserService<LaundaryPojo> {
//    UserPojo save(UserPojo userPojo);
    List<Booking> fetchAll();

    String save(UserPojo userPojo);

    Booking fetchById(Integer id);

    String save(BookingPojo bookingPojo);


    void deleteById(Integer id);


    String submitLaundary(com.example.hotelmanagementsystem.UserPojo.LaundaryPojo laundaryPojo);
}
