package com.example.hotelmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "food_order")
public class Food {
    @Id
    @SequenceGenerator(name = "hms_book_seq_gen", sequenceName = "hms_book_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "hms_book_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "item")
    private String item;
    @Column(name = "Room_No")
    private String room_no;
    @Column(name = "MobileNumber")
    private String mobile_no;
    @Column(name = "quantity")
    private int quantity;
}
