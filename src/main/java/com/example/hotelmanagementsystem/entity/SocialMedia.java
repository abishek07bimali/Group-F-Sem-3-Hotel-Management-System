package com.example.hotelmanagementsystem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Media_Link")
public class SocialMedia {
    @Id
    @SequenceGenerator(name = "hms_social_seq_gen", sequenceName = "hms_social_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "hms_social_seq_gen", strategy = GenerationType.SEQUENCE)

    private Integer id;

    @Column(name = "facebook_link")
    private String facebook_link;

    @Column(name = "instagram_link")
    private String instagram_link;

    @Column(name = "twitter_link")
    private String twitter_link;

    @Column(name = "discord_link")
    private String discord_link;

    @Column(name = "youtube_link")
    private String youtube_link;


}
