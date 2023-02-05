package com.example.hotelmanagementsystem.UserPojo;

import com.example.hotelmanagementsystem.entity.Laundary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class LaundaryPojo {

    private Integer id;

    private  String roomno;

    private String noofclothes;
    private String price;

    public LaundaryPojo(Laundary laundary) {
        this.id=laundary.getId();
        this.roomno=laundary.getRoomno();
        this.noofclothes=laundary.getNoofclothes();
        this.price=laundary.getPrice();

    }
}

