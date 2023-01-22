package com.example.hotelmanagementsystem.UserPojo;

import com.example.hotelmanagementsystem.entity.Feedback;
import com.example.hotelmanagementsystem.entity.User;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FeedbackPojo {

    private Integer id;

    private  String fullname;

    private String email;
    private  String subject;
    private  String message;

    public FeedbackPojo(Feedback feedback) {
        this.id=feedback.getId();
        this.fullname=feedback.getFullname();
        this.email=feedback.getEmail();
        this.subject=feedback.getSubject();
        this.message=feedback.getMessage();
    }
}
