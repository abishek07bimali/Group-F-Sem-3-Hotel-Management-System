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
@Table(name="blog")
public class Blog {
    @Id
    @SequenceGenerator(name = "hms_book_seq_gen", sequenceName = "hms_book_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "hms_book_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "author")
    private String author;

    @Column(name = "topic")
    private String topic;

    @Column(name = "date")
    private String date;

    @Column(name = "phoneNum")
    private String phoneNum;

    @Column(name = "content")
    private String content;

//    @Column(name="img")
//    private String img;

}
