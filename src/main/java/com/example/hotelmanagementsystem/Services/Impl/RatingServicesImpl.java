package com.example.hotelmanagementsystem.Services.Impl;

import com.example.hotelmanagementsystem.Services.RatingServices;
import com.example.hotelmanagementsystem.UserPojo.RatingPojo;
import com.example.hotelmanagementsystem.entity.Rating;
import com.example.hotelmanagementsystem.repo.RatingRepo;
import com.example.hotelmanagementsystem.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingServicesImpl implements RatingServices {
    private  final RatingRepo ratingRepo;
    private  final UserRepo userRepo;

    @Override
    public String save(RatingPojo ratingPojo) {
//        User relateduser = userRepo.findById(ratingPojo.getRating_user_id())
//                .orElseThrow(() -> new AppException("Invalid id for user type", HttpStatus.BAD_REQUEST));

        Rating rating=new Rating();
//        if(ratingPojo.getId()!=null){
//            rating.setId(ratingPojo.getId());
//        }
        rating.setRating(ratingPojo.getRating());
        rating.setReviews(ratingPojo.getReview());
//        rating.setFullname(ratingPojo.getFullname());
//        rating.setUser_id(relateduser);
        ratingRepo.save(rating);
        return "saved";
    }
}
