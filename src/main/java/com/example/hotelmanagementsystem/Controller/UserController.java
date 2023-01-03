package com.example.hotelmanagementsystem.Controller;

import com.example.hotelmanagementsystem.Services.UserService;
import com.example.hotelmanagementsystem.UserPojo.BookingPojo;
import com.example.hotelmanagementsystem.UserPojo.UserPojo;
import com.example.hotelmanagementsystem.entity.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.example.hotelmanagementsystem.UserPojo.ContactPojo;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/homepage")
    public String getRegisterPage() {
        return "homepage";
    }



    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new UserPojo());
        return "register";
    }

    @PostMapping("/save")
    public String saveUser(@Valid UserPojo userpojo) {
        userService.save(userpojo);
        return "redirect:homepage";
    }


    @GetMapping("/booking")
    public String BookHotel(Model model) {
        model.addAttribute("booking", new BookingPojo());
        return "booking";
    }


    @PostMapping("/savebook")
    public String saveBooking(@Valid BookingPojo bookingPojo) {
        userService.save(bookingPojo);
        return "redirect:homepage";
    }

//    @GetMapping("/contact")
//    public String getPage(){ return "contact_page";}
//
//    @PostMapping("/send-message")
//    public String submitMessage(@Valid ContactPojo contactPojo){
//        userService.submitMsg(contactPojo);
//        return "redirect:contact";
//    }




}
