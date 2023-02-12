package com.example.hotelmanagementsystem.Services;


import com.example.hotelmanagementsystem.UserPojo.*;
import com.example.hotelmanagementsystem.entity.Booking;
import com.example.hotelmanagementsystem.entity.Contact;
import com.example.hotelmanagementsystem.entity.Feedback;
import com.example.hotelmanagementsystem.entity.User;

import java.util.List;

public interface UserService {

    List<Booking> fetchAll();

    void sendEmail();

    String save(UserPojo userPojo);
    String update(UserPojo userPojo);

    Booking fetchById(Integer id);
    User getById(Integer id);
    String save(BookingPojo bookingPojo);
    String saveAdmin(AdminBooking adminBooking);

    String submitFeedback(FeedbackPojo feedbackPojo);
    String submitPlanning(surprisePlanningPojo surpriseplanningPojo);
    List<Feedback> fetchAllFeedback();
    List<Booking> findApplicationById(Integer id);







    String submitMsg(ContactPojo contactPojo);

    //    Contact fetchById(Integer id);
    void deleteById(Integer id);
    void deleteFeedback(Integer id);
    void deletecomment(Integer id);
    List<Contact> fetchAllContact();



    void processPasswordResetRequest(String email);

    void resetPassword(String email, String OTP, String password);


    String save(LaundaryPojo laundaryPojo);

    String save(BlogPojo blogPojo);
    User findByEmail(String email);
//    String save(BlogPojo blogPojo);
//    UserPojo findByEmail(String email);

//    List<Booking> getByKeyword( String keyword);
//    Page<Booking> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);


}
