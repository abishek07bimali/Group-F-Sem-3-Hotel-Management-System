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
@Table(name="comments")
public class Blog_Comment{
    @Id
    @SequenceGenerator(name = "hms_comment_seq_gen", sequenceName = "hms_comment_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "hms_comment_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "email")
    private String email;


    @Column(name = "comments")
    private String comment;

//    @ManyToOne
//    @JoinColumn(name = "Blog_ID", referencedColumnName = "id")
//    private Blog blogId;

}
