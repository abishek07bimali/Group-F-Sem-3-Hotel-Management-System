package com.example.hotelmanagementsystem.Services;


import com.example.hotelmanagementsystem.UserPojo.*;
import com.example.hotelmanagementsystem.entity.Booking;

import java.util.List;

public interface UserService {
//    String submitMsg(ContactPojo contactPojo);

    //    UserPojo save(UserPojo userPojo);
    List<Booking> fetchAll();

    String save(UserPojo userPojo);

    Booking fetchById(Integer id);

    String save(BookingPojo bookingPojo);

    String submitFeedback(FeedbackPojo feedbackPojo);

    String submitMsg(ContactPojo contactPojo);
    //    Contact fetchById(Integer id);
    void deleteById(Integer id);

//    String viewBlog(BlogPojo blogpojo);

    String save(BlogPojo blogPojo);
    UserPojo findByEmail(String email);
    UserPojo findByPassword(String password);
}
