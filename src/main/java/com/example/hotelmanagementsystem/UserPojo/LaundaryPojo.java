package com.example.hotelmanagementsystem.UserPojo;

public class LaundaryPojo {

    private Integer id;

    private  Integer roomno;

    private Integer noofclothes;
    private Integer print;

    public LaundaryPojo(Laundary laundary) {
        this.id=laundary.getId();
        this.roomno=laundary.getroomNo();
        this.noofclothes=laundary.getNoOfclothes();
        this.print=laundary.getPrint();

    }
}

