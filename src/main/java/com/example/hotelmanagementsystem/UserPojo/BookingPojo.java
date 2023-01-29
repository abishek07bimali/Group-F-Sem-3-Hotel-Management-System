package com.example.hotelmanagementsystem.UserPojo;

import com.example.hotelmanagementsystem.entity.Booking;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Builder

public class BookingPojo {
    private Integer id;
    private  String fullname;
    private  String checkin;
    private  String checkout;
    private  String room;
    private String amount;
    private  String date;
    private  String mobile_no;
    private  String number_of_people;

    private int user_id;

    public BookingPojo(Booking booking) {
        this.id=booking.getId();
        this.number_of_people=booking.getNumber_of_people();
        this.mobile_no=booking.getMobileNo();
        this.fullname=booking.getFullname();
        this.checkin=booking.getCheckin();
        this.checkout=booking.getCheckout();
        this.amount=booking.getTotal();
        this.date=booking.getDate();
        this.room=booking.getRooms();
        this.user_id=booking.getUser_id().getId();
    }
}
