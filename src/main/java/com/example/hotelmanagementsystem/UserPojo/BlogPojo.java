package com.example.hotelmanagementsystem.UserPojo;

import com.example.hotelmanagementsystem.entity.Blog;
import com.example.hotelmanagementsystem.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogPojo {
    private Integer id;
    private  String author;
    private  String topic;
    private  String date;
    private  String phoneNum;
    private  String content;
//    private  String img;

    public BlogPojo(Blog blog) {
        this.id=blog.getId();
        this.author=blog.getAuthor();
        this.topic=blog.getTopic();
        this.date=blog.getDate();
        this.phoneNum=blog.getPhoneNum();
        this.content=blog.getContent();

//        this.img=blog.getImg();
    }
}
