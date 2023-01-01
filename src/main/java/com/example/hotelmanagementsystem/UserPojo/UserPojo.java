package com.example.hotelmanagementsystem.UserPojo;

import com.example.hotelmanagementsystem.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPojo {
    private Integer id;
    private String email;
    private  String mobile_no;
    private  String fullname;
    private  String password;

    public UserPojo(User user) {
      this.id=user.getId();
      this.email=user.getEmail();
      this.mobile_no=user.getMobileNo();
      this.fullname=user.getFullname();
      this.password=user.getPassword();
    }
}
