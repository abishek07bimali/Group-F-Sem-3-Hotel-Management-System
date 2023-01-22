package com.example.hotelmanagementsystem.UserPojo;

import com.system.web_backend_individual1.Entity.Cab;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CabPojo {
    private Integer Id;
    private String Fullname;
    private String Phone;
    private String Car;
    private Integer People;
    private String Date;
    private String time;
    public CabPojo(Cab cab){
        this.Fullname = cab.getFullname();
        this.Phone=cab.getPhone();
        this.Car=cab.getCar();
        this.People=cab.getPeople();
        this.Date=cab.getDate();
        this.time=cab.getTime();
    }
}
