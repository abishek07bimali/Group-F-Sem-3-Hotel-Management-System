package com.example.hotelmanagementsystem.UserPojo;

import com.example.hotelmanagementsystem.entity.Cab;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "Full name can't be empty")
    private String Fullname;
    @NotEmpty(message = "Phone can't be empty")
    private String Phone;
    @NotEmpty(message = "Full name can't be empty")
    private String Car;
    @NotEmpty(message = "people can't be empty")
    private Integer People;
    @NotEmpty(message = "Date can't be empty")
    private String Date;
    @NotEmpty(message = "Time can't be empty")
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
