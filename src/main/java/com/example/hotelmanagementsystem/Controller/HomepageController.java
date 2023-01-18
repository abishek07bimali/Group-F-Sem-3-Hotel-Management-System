package com.example.hotelmanagementsystem.Controller;


import com.example.hotelmanagementsystem.UserPojo.ContactPojo;
import com.example.hotelmanagementsystem.UserPojo.FeedbackPojo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/homepage")
public class HomepageController {
    @GetMapping("")
    public String geHomepage(Model model) {
        model.addAttribute("feedback", new FeedbackPojo());

        return ("homepage");
    }


    @GetMapping("/services")
    public String getServicePage() {
        return "services";
    }

    @GetMapping("/gallery")
    public String getGallery() {
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
        return "weddingdetail";
    }

    @GetMapping("/profile")
    public String getUserProfile() {
        return "user_profile";
    }

}
