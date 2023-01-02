package com.example.hotelmanagementsystem.Services;


import com.example.hotelmanagementsystem.UserPojo.BookingPojo;
import com.example.hotelmanagementsystem.UserPojo.UserPojo;
import com.example.hotelmanagementsystem.entity.Booking;


import java.util.List;

public interface UserService {
//    UserPojo save(UserPojo userPojo);
    List<Booking> fetchAll();

    String save(UserPojo userPojo);
//     User fetchById(Integer id);

    String save(BookingPojo bookingPojo);

//    Booking deleteById(Integer id);

}
