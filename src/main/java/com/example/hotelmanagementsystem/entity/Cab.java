package com.example.hotelmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cab_details")
public class Cab {
    @Id
    @SequenceGenerator(name = "hms_cab_seq_gen",sequenceName ="hms_cab_id_seq",allocationSize = 1)
    @GeneratedValue(generator = "hms_cab_seq_gen",strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "FullName")
    private String fullname;
    @Column(name = "phone")
    private String phone;
    @Column(name = "Car")
    private String car;
    @Column(name = "no_of_people")
    private Integer people;
    @Column(name = "date")
    private String date;
    @Column(name = "time")
    private String time;

}
