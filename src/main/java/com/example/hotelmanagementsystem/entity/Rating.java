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
@Table(name="rating")
public class Rating {
    @Id
    @SequenceGenerator(name = "hms_social_seq_gen", sequenceName = "hms_social_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "hms_social_seq_gen", strategy = GenerationType.SEQUENCE)

    private Integer id;

    @Column(name = "rating")
    private String rating;

    @Column(name = "reviews")
    private String reviews;


    @OneToOne
    @JoinColumn(name = "rating_user_id", referencedColumnName = "id")
    private User user_id;

    @Column(name = "fullname")
    private String fullname;
}
