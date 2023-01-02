package com.example.hotelmanagementsystem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="booking")
public class Booking {
    @Id
    @SequenceGenerator(name = "hms_book_seq_gen", sequenceName = "hms_book_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "hms_book_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "fullname")
    private String fullname;


    @Column()
    private String email;

    @Column(name = "number_of_people")
    private String number_of_people;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "time")
    private String time;

}
