
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
@Table(name="surprisePlanning")
public class surprisePlanning{
    @Id
    @SequenceGenerator(name = "hms_book_seq_gen", sequenceName = "hms_book_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "hms_book_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer user_id;

    @Column(name = "startdate")
    private String startdate;

    @Column(name = "enddate")
    private String enddate;



    @Column(name = "eventtype")
    private String eventtype;

    @Column(name = "eventspace")
    private String eventspace;

    @Column(name="eventdescription")
    private String eventdescription;



}