package com.example.hotelmanagementsystem.Services;


import com.example.hotelmanagementsystem.UserPojo.BlogPojo;
import com.example.hotelmanagementsystem.UserPojo.BookingPojo;
import com.example.hotelmanagementsystem.UserPojo.LaundaryPojo;
import com.example.hotelmanagementsystem.UserPojo.ContactPojo;
import com.example.hotelmanagementsystem.UserPojo.UserPojo;
import com.example.hotelmanagementsystem.entity.Booking;
import com.example.hotelmanagementsystem.entity.Laundary;

import java.util.List;

public interface UserService<LaundaryPojo> {
//    UserPojo save(UserPojo userPojo);
public interface UserService {
//    String submitMsg(ContactPojo contactPojo);

    //    UserPojo save(UserPojo userPojo);
    List<Booking> fetchAll();

    String save(UserPojo userPojo);

    Booking fetchById(Integer id);

    String save(BookingPojo bookingPojo);


    void deleteById(Integer id);


    String submitLaundary(com.example.hotelmanagementsystem.UserPojo.LaundaryPojo laundaryPojo);
    String submitMsg(ContactPojo contactPojo);
//    Contact fetchById(Integer id);
    void deleteById(Integer id);

//    String viewBlog(BlogPojo blogpojo);

    String save(BlogPojo blogPojo);
    UserPojo findByEmail(String email);
    UserPojo findByPassword(String password);
}
