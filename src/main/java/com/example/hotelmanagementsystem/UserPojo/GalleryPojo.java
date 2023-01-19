package com.example.hotelmanagementsystem.UserPojo;

import com.example.hotelmanagementsystem.entity.Gallery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GalleryPojo {
    private Integer id;
    private String name;

    private MultipartFile image;

    public GalleryPojo(Gallery gallery) {
        this.id=gallery.getId();
        this.name=gallery.getName();
;
    }
}
