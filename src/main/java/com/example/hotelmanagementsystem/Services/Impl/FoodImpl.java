package com.example.hotelmanagementsystem.Services.Impl;

import com.example.hotelmanagementsystem.Services.FoodServices;
import com.example.hotelmanagementsystem.UserPojo.FoodPojo;
import com.example.hotelmanagementsystem.entity.Food;
import com.example.hotelmanagementsystem.repo.FoodRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodImpl implements FoodServices {
    public final FoodRepo foodRepo;


    @Override
    public String save(FoodPojo foodPojo){
        Food food = new Food();
        food.setItem(foodPojo.getItem());
        food.setRoom_no(foodPojo.getRoom_no());
        food.setMobile_no(foodPojo.getMobile_no());
        food.setQuantity(foodPojo.getQuantity());
        foodRepo.save(food);
        return null;
    }
}
