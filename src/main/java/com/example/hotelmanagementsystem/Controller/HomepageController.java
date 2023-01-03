package com.example.hotelmanagementsystem.Controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/homepage")
public class HomepageController {


    @GetMapping("/services")
    public String getServicePage() {
        return "services";
    }

    @GetMapping("/gallery")
    public String getGallery() {
        return "gallery";
    }

    @GetMapping("/blog")
    public String getBlogs() {
        return "blog";
    }

    @GetMapping("/nearby_places")
    public String getNearBy() {
        return "nearby_places";
    }

    @GetMapping("/rooms")
    public String getRooms() { return "rooms";
    }

}
