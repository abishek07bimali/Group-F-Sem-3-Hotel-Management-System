package com.example.hotelmanagementsystem.Controller;

import com.example.hotelmanagementsystem.Services.UserService;
import com.example.hotelmanagementsystem.UserPojo.BookingPojo;
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

    @GetMapping("/laundary")
    public String Laundary(Model model){
        model.addAttribute("laundary", new LaundaryPojo());
        return "laundary1";
    }
    @PostMapping("/savebook")
    public String saveLaundary(@Valid LaundaryPojo laundaryPojo) {
        userService.save(laundaryPojo);
        return "redirect:homepage";
    }




}
