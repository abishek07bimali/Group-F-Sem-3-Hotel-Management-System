package com.example.hotelmanagementsystem.Services;


import com.example.hotelmanagementsystem.UserPojo.UserPojo;
import com.example.hotelmanagementsystem.entity.User;


import java.util.List;

public interface UserService {
//    UserPojo save(UserPojo userPojo);
    List<User> fetchAll();

    String save(UserPojo userPojo);
     User fetchById(Integer id);
}
