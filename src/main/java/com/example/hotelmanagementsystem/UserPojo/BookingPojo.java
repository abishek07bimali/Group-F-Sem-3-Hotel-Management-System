package com.example.hotelmanagementsystem.UserPojo;

import com.example.hotelmanagementsystem.entity.Booking;
import com.example.hotelmanagementsystem.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingPojo {
    private Integer id;
    private String email;
    private  String mobile_no;
    private  String number_of_people;
    private  String fullname;
    private  String time;

    public BookingPojo(Booking booking) {
        this.id=booking.getId();
        this.email=booking.getEmail();
        this.number_of_people=booking.getNumber_of_people();
        this.mobile_no=booking.getMobileNo();
        this.fullname=booking.getFullname();
        this.time=booking.getTime();
    }
}
