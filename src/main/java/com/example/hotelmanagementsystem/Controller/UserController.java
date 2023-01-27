package com.example.hotelmanagementsystem.Controller;

import com.example.hotelmanagementsystem.Services.BlogServices;
import com.example.hotelmanagementsystem.Services.UserService;
import com.example.hotelmanagementsystem.UserPojo.*;
import com.example.hotelmanagementsystem.UserPojo.BlogPojo;
import com.example.hotelmanagementsystem.UserPojo.BookingPojo;
import com.example.hotelmanagementsystem.UserPojo.LaundaryPojo;
import com.example.hotelmanagementsystem.UserPojo.ContactPojo;
import com.example.hotelmanagementsystem.UserPojo.UserPojo;
import com.example.hotelmanagementsystem.entity.Blog;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final BlogServices blogServices;

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new UserPojo());
        return "register";
    }

    @PostMapping("/save")
    public String saveUser(@Valid UserPojo userpojo) {
        userService.save(userpojo);
        return "login";
    }


    @GetMapping("/booking")
    public String BookHotel(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        model.addAttribute("booking", new BookingPojo());
        return "booking";
    }


    @PostMapping("/savebook")
    public String saveBooking(@Valid BookingPojo bookingPojo) {
        userService.save(bookingPojo);
        return "homepage";
    }

    @GetMapping("/contact")
    public String getPage( Model model){
        model.addAttribute("contact", new ContactPojo());
        return "contact_page";}

    @PostMapping("/send-message")
    public String submitMessage(@Valid ContactPojo contactPojo){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        userService.submitMsg(contactPojo);
        return "redirect:contact";
    }


    @PostMapping("/savefeedback")
    public String getFeedback(@Valid FeedbackPojo feedbackPojo){
        userService.submitFeedback(feedbackPojo);
        return "redirect:/homepage";
    }


//     @GetMapping("/viewBlog")
    @PostMapping("/savelaundary")
    public String getLaundary(@Valid LaundaryPojo laundaryPojo) {
        userService.submitLaundary(laundaryPojo);
        return "redirect:/laundary1";

    }
//    @GetMapping("/blog")
//    public String viewUserBlog(Model model){
//          List<Blog> blogs = blogServices.fetchAll();
//          model.addAttribute("blog", blogs.stream().map(blog ->
//                  blog.builder()
//                          .id(blog.getId())
//                          .author(blog.getAuthor())
//                          .topic(blog.getTopic())
//                          .date(blog.getDate())
//                          .phoneNum(blog.getPhoneNum())
//                          .content(blog.getPhoneNum())
//                  ));
//        return "blog";
//    }

    @GetMapping("/event")
    public String getEventPage() {
        return ("event");
    }

    @GetMapping("/pickup_request")
    public String getPickupPage() {
        return ("picked_up");
    }


    @GetMapping("/rating")
    public String getRating() {
        return ("ratings");
    }
}
