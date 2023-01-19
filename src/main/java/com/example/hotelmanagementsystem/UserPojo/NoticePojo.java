package com.example.hotelmanagementsystem.UserPojo;

import com.example.hotelmanagementsystem.entity.Notices;
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
    private  String content;
    private  String date_published;
    NoticePojo(Notices notice){
        this.id=notice.getId();
        this.content=notice.getContent();
        this.topic=notice.getTopic();
        this.date_published=notice.getDate_published();
        this.publisher=notice.getPublisher();
    }
}
