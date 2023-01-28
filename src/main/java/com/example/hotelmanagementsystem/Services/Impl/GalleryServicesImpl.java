package com.example.hotelmanagementsystem.Services.Impl;

import com.example.hotelmanagementsystem.Services.GalleryServices;
import com.example.hotelmanagementsystem.UserPojo.GalleryPojo;
import com.example.hotelmanagementsystem.entity.Gallery;
import com.example.hotelmanagementsystem.repo.GalleryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GalleryServicesImpl implements GalleryServices {
    private final GalleryRepo galleryRepo;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/Gallery";

    @Override
    public GalleryPojo save(GalleryPojo galleryPojo) throws IOException {
        Gallery gallery;
        if (galleryPojo.getId() != null) {
            gallery = galleryRepo.findById(galleryPojo.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
        } else {
            gallery = new Gallery();
        }
        gallery.setName(galleryPojo.getName());

        if(galleryPojo.getImage()!=null){
            StringBuilder fileNames = new StringBuilder();
            System.out.println(UPLOAD_DIRECTORY);
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, galleryPojo.getImage().getOriginalFilename());
            fileNames.append(galleryPojo.getImage().getOriginalFilename());
            Files.write(fileNameAndPath, galleryPojo.getImage().getBytes());

            gallery.setImage(galleryPojo.getImage().getOriginalFilename());
        }
        galleryRepo.save(gallery);
        return new GalleryPojo(gallery);
    }

    @Override
    public List<Gallery> fetchAll() {
        return galleryRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        galleryRepo.deleteById(id);
    }
}
