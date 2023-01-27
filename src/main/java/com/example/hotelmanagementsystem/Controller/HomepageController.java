package com.example.hotelmanagementsystem.Controller;
// npm install datatables.net    # Core library
// npm install datatables.net-dt # Styling

import com.example.hotelmanagementsystem.Services.BlogServices;
import com.example.hotelmanagementsystem.Services.GalleryServices;
import com.example.hotelmanagementsystem.Services.UserService;
import com.example.hotelmanagementsystem.UserPojo.ContactPojo;
import com.example.hotelmanagementsystem.UserPojo.FeedbackPojo;
import com.example.hotelmanagementsystem.entity.Blog;
import com.example.hotelmanagementsystem.entity.Gallery;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Principal;
import java.util.Base64;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/homepage")
public class HomepageController {
    private  final GalleryServices galleryServices;
    private final BlogServices blogServices;
    private  final UserService userService;

    @GetMapping("")
    public String geHomepage(Model model, Principal principal) {
        model.addAttribute("feedback", new FeedbackPojo());
//        model.addAttribute("info",userService.findByEmail(principal.getName()));
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
    public String viewUserBlog(Model model){
        List<Blog> blogs = blogServices.fetchAll();
        model.addAttribute("blog", blogs.stream().map(blog ->
                Blog.builder()
                        .id(blog.getId())
                        .author(blog.getAuthor())
                        .topic(blog.getTopic())
                        .date(blog.getDate())
                        .phoneNum(blog.getPhoneNum())
                        .content(blog.getContent())
                        .build()
        ));
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

    @GetMapping("/cabbook")
    public String getCabBook() {
        return "redirect:/cab/book";
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
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
