package com.example.hotelmanagementsystem.Services.Impl;

import com.example.hotelmanagementsystem.Services.UserService;
import com.example.hotelmanagementsystem.UserPojo.UserPojo;
import com.example.hotelmanagementsystem.entity.User;
import com.example.hotelmanagementsystem.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public final UserRepo userRepo;

    public List<User> fetchAll(){
        return this.userRepo.findAll();
    }

    @Override
    public String save(UserPojo userPojo) {
        User user=new User();
        user.setEmail(userPojo.getEmail());
        user.setFullname(userPojo.getFullname());
        user.setMobileNo(userPojo.getMobile_no());
        user.setPassword(userPojo.getPassword());
        userRepo.save(user);
        return "created";
    }

    @Override
    public User fetchById(Integer id) {
        return userRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

}

