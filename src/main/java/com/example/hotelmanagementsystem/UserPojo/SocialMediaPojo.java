package com.example.hotelmanagementsystem.UserPojo;

import com.example.hotelmanagementsystem.entity.SocialMedia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import javax.print.attribute.standard.Media;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocialMediaPojo {
    private Integer id;
    private  String facebook_link;
    private  String instagram_link;
    private  String twitter_link;
//    private  String discord_link;
    private  String youtube_link;
//    private  String img;

    public SocialMediaPojo(SocialMedia socialMedia) {
        this.id=socialMedia.getId();
        this.facebook_link= socialMedia.getFacebook_link();
        this.instagram_link=socialMedia.getInstagram_link();
        this.twitter_link=socialMedia.getTwitter_link();
//        this.discord_link=socialMedia.getDiscord_link();
        this.youtube_link=socialMedia.getYoutube_link();

    }
}