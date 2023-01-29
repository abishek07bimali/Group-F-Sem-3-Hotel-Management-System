package com.example.hotelmanagementsystem.entity;


import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="gallery")
public class Gallery {
    @Id
    @SequenceGenerator(name = "hms_book_seq_gen", sequenceName = "hms_book_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "hms_book_seq_gen", strategy = GenerationType.SEQUENCE)

    private Integer id;

    @Column(name = "name")
    private String name;

    private String image;

    @Transient
    private String imageBase64;


}
