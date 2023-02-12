package com.example.hotelmanagementsystem.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users", uniqueConstraints = {
        @UniqueConstraint(name = "hms_user_email", columnNames = "email")
})
public class User implements UserDetails {
    @Id
    @SequenceGenerator(name = "hms_user_seq_gen", sequenceName = "hms_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "hms_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "fullname", nullable = false)
    private String fullname;

    @Column(nullable = false)
    private String email;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "OTP")
    private String OTP;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



}
