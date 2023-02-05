package com.example.hotelmanagementsystem.Controller;
// npm install datatables.net    # Core library
// npm install datatables.net-dt # Styling

import com.example.hotelmanagementsystem.Services.BlogServices;
import com.example.hotelmanagementsystem.Services.GalleryServices;
import com.example.hotelmanagementsystem.Services.SocialMediaServices;
import com.example.hotelmanagementsystem.Services.UserService;
import com.example.hotelmanagementsystem.UserPojo.*;
import com.example.hotelmanagementsystem.entity.Blog;
import com.example.hotelmanagementsystem.entity.Booking;
import com.example.hotelmanagementsystem.entity.Gallery;
import com.example.hotelmanagementsystem.entity.SocialMedia;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Principal;
import java.util.Base64;
import java.util.Collection;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/homepage")
public class HomepageController {
    private  final GalleryServices galleryServices;
    private final BlogServices blogServices;
    private  final UserService userService;
    private final SocialMediaServices socialMediaServices;


    @GetMapping("")
    public String geHomepage(Model model, Principal principal, Authentication authentication) {

        if (authentication!=null){
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority grantedAuthority : authorities) {
                if (grantedAuthority.getAuthority().equals("Admin")) {
                    return "redirect:/admin/list";
                }
            }
        }
        model.addAttribute("feedback", new FeedbackPojo());

//        model.addAttribute("info",userService.findByEmail(principal.getName()));
        return ("homepage");
    }


    @GetMapping("/services")
    public String getServicePage(Model model , Principal principal) {

//        model.addAttribute("info",userService.findByEmail(principal.getName()));
        return "services";
    }

    @GetMapping("/gallery")
    public String getGallery( Model model,Principal principal) {
        List<Gallery> gallerys = galleryServices.fetchAll();
        model.addAttribute("imagelist", gallerys.stream().map(gallery ->
                Gallery.builder()
                        .id(gallery.getId())
                        .name(gallery.getName())
                        .imageBase64(getImageBase64(gallery.getImage()))
                        .build()

        ));
//        model.addAttribute("info",userService.findByEmail(principal.getName()));
        return "gallery";
    }

    @GetMapping("/viewblog")
    public String viewUserBlog(Model model,Principal principal) {
//        model.addAttribute("blog", new BlogPojo());
//        model.addAttribute("info",userService.findByEmail(principal.getName()));
        model.addAttribute("comment", new CommentPojo());
//        return "blog";
//    }


//    public String viewUserBlog(Model model){
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
    public String getNearBy(Model model,Principal principal)
    {
//        model.addAttribute("info",userService.findByEmail(principal.getName()));
        return "nearby_places";
    }

    @GetMapping("/rooms")
    public String getRooms(Model model, Principal principal) {
//        model.addAttribute("info",userService.findByEmail(principal.getName()));
        model.addAttribute("rating", new RatingPojo());
        return "rooms";
    }

    @GetMapping("/cabbook")
    public String getCabBook() {
        return "redirect:/cab/book";
    }



    @GetMapping("/packages")
    public String getPackages(Model model) {
        model.addAttribute("surprisePlanning", new surprisePlanningPojo());
        return "seepackage";
    }

    @GetMapping("/contact")
    public String getPage( Model model, Principal principal){
        model.addAttribute("contact", new ContactPojo());
//        model.addAttribute("info",userService.findByEmail(principal.getName()));
        return "contact_page";}

    @GetMapping("/about")
    public String getAbout(Model model, Principal principal) {
//        model.addAttribute("info",userService.findByEmail(principal.getName()));
        List<SocialMedia> socialMedia = socialMediaServices.fetchAll();
        model.addAttribute("medialink", socialMedia);
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

    @GetMapping("/culinary")
    public String getClui() {
        return "culinaryDelight";
    }

    @GetMapping("/profile")
    public String getUserProfile (Integer id,Model model, Principal principal) {
//        User user= userService.getById(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        model.addAttribute("update", new UserPojo());
        model.addAttribute("info",userService.findByEmail(principal.getName()));
        return "user_profile";
    }
    @PostMapping("/updateUser")
    public String updateUser(@Valid UserPojo userpojo) {
        userService.save(userpojo);
        return "redirect:/homepage/profile";
    }
    @GetMapping("/appledjobs/{id}")
    public  String getBookingById(@PathVariable("id") Integer id, Model model, Principal principal){
        List<Booking> bookings= userService.findApplicationById(id);
        model.addAttribute("applicationData",bookings);
        model.addAttribute("userdata",userService.findByEmail(principal.getName()));
        return "seeHistory";

    }
    @GetMapping("/deletebooking/{id}")
    public String deleteUserBooking(@PathVariable("id") Integer id) {
        userService.deleteById(id);
        return "redirect:/homepage/profile";
    }

    @GetMapping("/pay")
    public  String qrScan(){
        return "qrscanner";
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
