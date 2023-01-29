package com.example.hotelmanagementsystem;

import com.example.hotelmanagementsystem.entity.Booking;
import com.example.hotelmanagementsystem.repo.BookingRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookingRepositoryTest {

//    public class



    @Autowired
    private BookingRepo bookingRepo;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveBookingTest() {

//        Booking booking = new Booking();
//        booking.setFullname("rak");

        Booking booking = Booking.builder()
                .fullname("rak")
                .rooms("single")
                .checkin("23/1/2023")
                .checkout("30/1/2023")
                .mobileNo("9888888888")
                .number_of_people("2")
                .build();


        bookingRepo.save(booking);

//        Assumption of the above datta

        Assertions.assertThat(booking.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getBookingTest() {

        Booking booking = Booking.builder()
                .fullname("rak")
                .rooms("single")
                .checkin("23/1/2023")
                .checkout("30/1/2023")
                .mobileNo("9888888888")
                .number_of_people("2")
                .build();


        bookingRepo.save(booking);


        Booking bookingCreated = bookingRepo.findById(booking.getId()).get();
        Assertions.assertThat(bookingCreated.getId()).isEqualTo(booking.getId());

    }

    @Test
    @Order(3)
    public void getListOfBookingTest(){
        Booking booking = Booking.builder()
                .fullname("rak")
                .rooms("single")
                .checkin("23/1/2023")
                .checkout("30/1/2023")
                .mobileNo("9888888888")
                .number_of_people("2")
                .build();


        bookingRepo.save(booking);
        List<Booking> Booking = bookingRepo.findAll();
        Assertions.assertThat(Booking.size()).isGreaterThan(0);
    }


    @Test
    @Order(4)
    public void updateBookingTest(){

        Booking booking = Booking.builder()
                .fullname("rak")
                .rooms("single")
                .checkin("23/1/2023")
                .checkout("30/1/2023")
                .mobileNo("9888888888")
                .number_of_people("2")
                .build();

        bookingRepo.save(booking);

        Booking booking1  = bookingRepo.findById(booking.getId()).get();

        booking1.setFullname("new name");

        Booking bookingUpdated  = bookingRepo.save(booking);

        Assertions.assertThat(bookingUpdated.getFullname()).isEqualTo("new name");

    }

    @Test
    @Order(5)
    public void deleteBookingTest(){

        Booking booking = Booking.builder()
                .fullname("rak")
                .rooms("single")
                .checkin("23/1/2023")
                .checkout("30/1/2023")
                .mobileNo("9888888888")
                .number_of_people("2")
                .build();

        bookingRepo.save(booking);

//        @Query(value = "SELECT * from")

        Booking booking1 = bookingRepo.findById(booking.getId()).get();
        bookingRepo.delete(booking1);

        Booking booking2 = null;
        Optional<Booking> optionalBooking = bookingRepo.findBookingByFullname("rak");
        if(optionalBooking.isPresent()){
            booking2 = optionalBooking.get();
        }

        Assertions.assertThat(booking2).isNull();
//        Assertions.assertThat(booking1.getId()).isNull();
    }

}
