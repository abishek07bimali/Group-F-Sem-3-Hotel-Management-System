package com.example.hotelmanagementsystem.Services;

import com.example.hotelmanagementsystem.UserPojo.GalleryPojo;
import com.example.hotelmanagementsystem.entity.Gallery;

import java.io.IOException;
import java.util.List;

public interface GalleryServices {
    GalleryPojo save(GalleryPojo galleryPojo) throws IOException;
    List<Gallery> fetchAll();

}
