package com.example.hotelmanagementsystem.Services;


import com.example.hotelmanagementsystem.UserPojo.BookingPojo;
import com.example.hotelmanagementsystem.UserPojo.UserPojo;
import com.example.hotelmanagementsystem.entity.Booking;

//import com.example.hotelmanagementsystem.UserPojo.ContactPojo;

import java.util.List;

public interface UserService {
//    UserPojo save(UserPojo userPojo);
    List<Booking> fetchAll();

    String save(UserPojo userPojo);
//     User fetchById(Integer id);

    String save(BookingPojo bookingPojo);

//    String submitMsg(ContactPojo contactPojo);
////    Contact fetchById(Integer id);

}
