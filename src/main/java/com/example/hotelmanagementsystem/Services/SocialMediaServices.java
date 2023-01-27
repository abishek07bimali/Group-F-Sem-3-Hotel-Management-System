package com.example.hotelmanagementsystem.Services;

import com.example.hotelmanagementsystem.UserPojo.SocialMediaPojo;
import com.example.hotelmanagementsystem.entity.SocialMedia;


import java.util.List;

public interface SocialMediaServices {

    String save(SocialMediaPojo socialMediaPojo);

    List<SocialMedia> fetchAll();

    SocialMedia fetchById(Integer id);
    void deleteById(Integer id);


}
