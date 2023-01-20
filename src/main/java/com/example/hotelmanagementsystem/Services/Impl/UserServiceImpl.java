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

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public final UserRepo userRepo;
    public final BookingRepo bookingRepo;






    @Override
    public String save(UserPojo userPojo) {
        User user = new User();
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
        if(bookingPojo.getId()!=null){
            booking.setId(bookingPojo.getId());
        }
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



    @Override
    public Booking fetchById(Integer id) {
        return bookingRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

//    @Override
//    public Booking deleteById(Integer id) {
//        return bookingRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
//    }

    public List<Booking> fetchAll(){
        return this.bookingRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        bookingRepo.deleteById(id);



    }
    @Override
    public String save(UserPojo.LaundaryPojo laundaryPojo) {
        Laundary laundary=new Laundary();
        if(laundaryPojo.getId()!=null){
            laundary.setId(laundaryPojo.getId());
        }
        laundary.Room_No(laundaryPojo.getRoom_No());
        laundary.setNumber_of_clothes(laundaryPojo.getNumber_of_clothes());
        laundary.setPrice(laundaryPojo.getCheckin());
        laundaryRepo.save(laundary);
        return null;
    }





}

