package com.example.hotelmanagementsystem.UserPojo;

import com.example.hotelmanagementsystem.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodPojo {
    private int id;
    private String item;
    private String room_no;
    private String mobile_no;
    private int quantity;

    public FoodPojo(Food food){
        this.id = food.getId();
        this.item= food.getItem();
        this.room_no = food.getRoom_no();
        this.mobile_no = food.getMobile_no();
        this.quantity=food.getQuantity();
    }

}
