package com.example.hotelmanagementsystem.Services.Impl;


import com.example.hotelmanagementsystem.Services.SocialMediaServices;
import com.example.hotelmanagementsystem.UserPojo.SocialMediaPojo;
import com.example.hotelmanagementsystem.entity.SocialMedia;
import com.example.hotelmanagementsystem.repo.SocialMediaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SocialMediaServicesImpl implements SocialMediaServices {
    private  final SocialMediaRepo socialMediaRepo;

    @Override
    public String save(SocialMediaPojo socialMediaPojo) {
        SocialMedia socialMedia =new SocialMedia();
        if(socialMediaPojo.getId()!=null){
            socialMedia.setId(socialMediaPojo.getId());
        }
        socialMedia.setFacebook_link(socialMediaPojo.getFacebook_link());
        socialMedia.setInstagram_link(socialMediaPojo.getInstagram_link());
        socialMedia.setTwitter_link(socialMediaPojo.getTwitter_link());
//        socialMedia.setDiscord_link(socialMediaPojo.getDiscord_link());
        socialMedia.setYoutube_link(socialMediaPojo.getYoutube_link());
//        SocialMedia.setImg(SocialMediaPojo.getImg());
        socialMediaRepo.save(socialMedia);
        return null;
    }

    @Override
    public List<SocialMedia> fetchAll() {
        return socialMediaRepo.findAll();
//        return null;
    }


    @Override
    public SocialMedia fetchById(Integer id) {
        return socialMediaRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));

    }

    @Override
    public void deleteById(Integer id) {
        socialMediaRepo.deleteById(id);
    }

}

