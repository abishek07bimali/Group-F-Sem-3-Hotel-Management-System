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
@Table(name="notice")
public class Notices {
    @Id
    @SequenceGenerator(name = "hms_book_seq_gen", sequenceName = "hms_book_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "hms_book_seq_gen", strategy = GenerationType.SEQUENCE)

    private Integer id;

    @Column(name = "punblisher")
    private String publisher;

    @Column(name = "topic")
    private String topic;

    @Column(name = "date")
    private String date;

    @Column(name = "Date")
    private String date_published;


//    @Column(name="img")
//    private String img;

}
