package com.example.hotelmanagementsystem.Controller;


import com.example.hotelmanagementsystem.UserPojo.BlogPojo;
import com.example.hotelmanagementsystem.UserPojo.ContactPojo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/contact")
    public String getPage( Model model){
        model.addAttribute("contact", new ContactPojo());
        return "contact_page";}


}
