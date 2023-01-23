package com.example.hotelmanagementsystem.Controller;

import com.example.hotelmanagementsystem.Services.UserService;
import com.example.hotelmanagementsystem.UserPojo.*;
import com.example.hotelmanagementsystem.UserPojo.BlogPojo;
import com.example.hotelmanagementsystem.UserPojo.BookingPojo;
import com.example.hotelmanagementsystem.UserPojo.LaundaryPojo;
import com.example.hotelmanagementsystem.UserPojo.ContactPojo;
import com.example.hotelmanagementsystem.UserPojo.UserPojo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

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
        model.addAttribute("booking", new BookingPojo());
        return "booking";
    }


    @PostMapping("/savebook")
    public String saveBooking(@Valid BookingPojo bookingPojo) {
        userService.save(bookingPojo);
        return "redirect:/homepage";
    }

    @GetMapping("/contact")
    public String getPage( Model model){
        model.addAttribute("contact", new ContactPojo());
        return "contact_page";}

    @PostMapping("/send-message")
    public String submitMessage(@Valid ContactPojo contactPojo){
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
      @GetMapping("/viewBlog")
    public String viewUserBlog(Model model){
        model.addAttribute("blog", new BlogPojo());
        return "blog";
    }

    @GetMapping("/event")
    public String getEventPage() {
        return ("event");
    }

    @GetMapping("/pickup_request")
    public String getPickupPage() {
        return ("picked_up");
    }
}
