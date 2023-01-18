package com.example.hotelmanagementsystem.UserPojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoticePojo {
    private Integer id;
    private String publisher;
    private  String topic;
    private  String date;
    private  String date_published;
}
