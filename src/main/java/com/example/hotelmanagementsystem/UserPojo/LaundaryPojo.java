package com.example.hotelmanagementsystem.UserPojo;

import com.example.hotelmanagementsystem.entity.Laundary;

public class LaundaryPojo {

    private Integer id;

    private  Integer roomno;

    private Integer noofclothes;
    private Integer print;

    public LaundaryPojo(Laundary laundary) {
        this.id=laundary.getId();
        this.roomno=laundary.getRoomno();
        this.noofclothes=laundary.getNoofclothes();
        this.print=laundary.getPrint();

    }

}

