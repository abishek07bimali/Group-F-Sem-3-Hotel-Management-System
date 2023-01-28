package com.example.hotelmanagementsystem.UserPojo;

import com.example.hotelmanagementsystem.entity.Rating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RatingPojo {
    private Integer id;
    private String rating;
    private  String review;
//    private  String fullname;
//    private  int rating_user_id;

    public RatingPojo(Rating rating) {
        this.id=rating.getId();
        this.rating=rating.getRating();
        this.review=rating.getReviews();
//        this.fullname=rating.getFullname();
//        this.rating_user_id=rating.getUser_id().getId();
    }
}
