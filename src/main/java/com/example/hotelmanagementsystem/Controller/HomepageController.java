package com.example.hotelmanagementsystem.Controller;


import com.example.hotelmanagementsystem.Services.GalleryServices;
import com.example.hotelmanagementsystem.UserPojo.ContactPojo;
import com.example.hotelmanagementsystem.entity.Gallery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/homepage")
public class HomepageController {
    private  final GalleryServices galleryServices;

    @GetMapping("")
    public String geHomepage() {
        return ("homepage");
    }


    @GetMapping("/services")
    public String getServicePage() {
        return "services";
    }

    @GetMapping("/gallery")
    public String getGallery( Model model) {
        List<Gallery> gallerys = galleryServices.fetchAll();
        model.addAttribute("imagelist", gallerys.stream().map(gallery ->
                Gallery.builder()
                        .id(gallery.getId())
                        .name(gallery.getName())
                        .imageBase64(getImageBase64(gallery.getImage()))
                        .build()

        ));
        return "gallery";
    }

    @GetMapping("/viewblog")
    public String viewUserBlog(){
//        model.addAttribute("blog", new BlogPojo());
        return "blog";
    }

    @GetMapping("/nearby_places")
    public String getNearBy() {
        return "nearby_places";
    }

    @GetMapping("/rooms")
    public String getRooms() {
        return "rooms";
    }
}


    @GetMapping("/packages")
    public String getpackages() {
        return "seepackage";
    }

    @GetMapping("/contact")
    public String getPage( Model model){
        model.addAttribute("contact", new ContactPojo());
        return "contact_page";}

    @GetMapping("/about")
    public String getAbout() {
        return "about-us";
    }


    @GetMapping("/birthday")
    public String getBirthday() {
        return "birthdaydetail";
    }

    @GetMapping("/anniversary")
    public String getAnni() {
        return "anniversarydetail";
    }

    @GetMapping("/wedding")
    public String getWeeding() {
        return "weddingPackage";
    }

    @GetMapping("/profile")
    public String getUserProfile() {
        return "user_profile";
    }


    public String getImageBase64(String fileName) {
        String filePath = System.getProperty("user.dir") + "/Gallery/";
        File file = new File(filePath + fileName);
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;
    }
}
