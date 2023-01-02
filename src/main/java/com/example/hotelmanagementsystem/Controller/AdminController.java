//package com.example.hotelmanagementsystem.Controller;
//import com.example.hotelmanagementsystem.Services.UserService;
//import com.example.hotelmanagementsystem.UserPojo.UserPojo;
//import com.example.hotelmanagementsystem.entity.User;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/admin")
//public class AdminController {
//    private final UserService userService;
//
//    @GetMapping("/booking")
//    public String createUser(Model model) {
//        model.addAttribute("user", new UserPojo());
//        return "booking";
//    }
//
//    @PostMapping("/save")
//    public String saveUser(@Valid UserPojo userpojo) {
//        userService.save(userpojo);
//        return "redirect:homepage";
//    }
//}
