package com.example.hotelmanagementsystem.Controller;

import com.example.hotelmanagementsystem.Services.CommentServices;
import com.example.hotelmanagementsystem.Services.UserService;
import com.example.hotelmanagementsystem.UserPojo.*;
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

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final CommentServices commentServices;

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
    public String BookHotel(Integer id, Model model, Principal principal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
//        User user= userService.findByEmail(principal.getName());
        model.addAttribute("booking", new BookingPojo());
//        model.addAttribute("userdata",userService.getById(id));
        model.addAttribute("info",userService.findByEmail(principal.getName()));

//        model.addAttribute("data",user);
//        model.addAttribute("join",new UserPojo(user));
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        userService.submitMsg(contactPojo);
        return "redirect:contact";
    }


    @PostMapping("/savefeedback")
    public String getFeedback(@Valid FeedbackPojo feedbackPojo){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        userService.submitFeedback(feedbackPojo);
        return "redirect:/homepage";
    }


//     @GetMapping("/viewBlog")
    @PostMapping("/savelaundary")
    public String getLaundary(@Valid LaundaryPojo laundaryPojo) {
        userService.submitLaundary(laundaryPojo);
        return "redirect:/laundary1";

    }
//      @GetMapping("/viewBlog")
//    public String viewUserBlog(Model model){
////        model.addAttribute("blog", new BlogPojo());
//        model.addAttribute("comment", new CommentPojo());
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


    @PostMapping("/saveComment")
    public String getComment( @Valid CommentPojo commentPojo) {
        commentServices.save(commentPojo);
        return ("redirect:/homepage/viewblog");
    }


}
