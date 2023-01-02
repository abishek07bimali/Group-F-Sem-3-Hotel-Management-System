package com.example.hotelmanagementsystem.Controller;
import com.example.hotelmanagementsystem.Services.UserService;
import com.example.hotelmanagementsystem.entity.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    @GetMapping("/list")
    public String getUserList(Model model) {
        List<Booking> bookings = userService.fetchAll();
        model.addAttribute("bookinglist", bookings);
        return "viewCustomerlist";
    }

}
