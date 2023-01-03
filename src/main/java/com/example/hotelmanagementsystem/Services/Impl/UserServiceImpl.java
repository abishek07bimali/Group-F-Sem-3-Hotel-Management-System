package com.example.hotelmanagementsystem.Services.Impl;

import com.example.hotelmanagementsystem.Services.UserService;
import com.example.hotelmanagementsystem.UserPojo.BookingPojo;
import com.example.hotelmanagementsystem.UserPojo.UserPojo;
import com.example.hotelmanagementsystem.entity.Booking;
import com.example.hotelmanagementsystem.entity.User;
import com.example.hotelmanagementsystem.repo.BookingRepo;
import com.example.hotelmanagementsystem.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//import com.example.hotelmanagementsystem.UserPojo.ContactPojo;
//import com.example.hotelmanagementsystem.entity.Contact;
//import com.example.hotelmanagementsystem.repo.ContactRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public final UserRepo userRepo;
    public final BookingRepo bookingRepo;
//    public final ContactRepo contactRepo;



    @Override
    public String save(UserPojo userPojo) {
        User user=new User();
        user.setEmail(userPojo.getEmail());
        user.setFullname(userPojo.getFullname());
        user.setMobileNo(userPojo.getMobile_no());
        user.setPassword(userPojo.getPassword());
        userRepo.save(user);
        return "created";
    }

    @Override
    public String save(BookingPojo bookingPojo) {
        Booking booking=new Booking();
        booking.setFullname(bookingPojo.getFullname());
        booking.setNumber_of_people(bookingPojo.getNumber_of_people());
        booking.setMobileNo(bookingPojo.getMobile_no());
        booking.setCheckin(bookingPojo.getCheckin());
        booking.setCheckout(bookingPojo.getCheckout());
        booking.setDate(bookingPojo.getDate());
        booking.setTotal(bookingPojo.getAmount());
        booking.setRooms(bookingPojo.getRoom());
        bookingRepo.save(booking);
        return null;
    }

//    @Override
//    public String submitMsg(ContactPojo contactPojo) {
//        Contact contact=new Contact();
//        contact.setFullname(contactPojo.getFullname());
//        contact.setEmail(contactPojo.getEmail());
//        contact.setSubject(contactPojo.getSubject());
//        contact.setMessage(contactPojo.getMessage());
//        contactRepo.save(contact);
//        return "sent";
//    }

    public List<Booking> fetchAll(){
        return this.bookingRepo.findAll();
    }




}

