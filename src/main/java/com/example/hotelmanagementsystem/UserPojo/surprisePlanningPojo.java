package com.example.hotelmanagementsystem.UserPojo;


import com.example.hotelmanagementsystem.entity.surprisePlanning;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class surprisePlanningPojo {
    private Integer user_id;
    private  String startdate;
    private  String enddate;
    private  String eventtype;
    private  String eventspace;
    private String eventdescription;


    public surprisePlanningPojo(surprisePlanning surpriseplanning) {
        this.user_id=surpriseplanning.getUser_id();
        this.startdate=surpriseplanning.getStartdate();
        this.enddate=surpriseplanning.getEnddate();
        this.eventtype=surpriseplanning.getEventtype();
        this.eventspace=surpriseplanning.getEventspace();
        this.eventdescription=surpriseplanning.getEventdescription();
    }
}

