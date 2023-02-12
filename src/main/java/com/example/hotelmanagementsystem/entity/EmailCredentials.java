package com.example.hotelmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class EmailCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Email_Seq_GEN")
    @SequenceGenerator(name = "Email_Seq_GEN", sequenceName = "Email_Seq", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    private String host;
    private String port;
    private Date date;
    private Boolean active;
    private String protocol;

}
