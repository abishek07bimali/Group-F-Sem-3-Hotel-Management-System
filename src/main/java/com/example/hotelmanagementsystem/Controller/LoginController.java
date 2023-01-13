package com.example.hotelmanagementsystem.Controller;

import com.example.hotelmanagementsystem.Services.UserService;
import com.example.hotelmanagementsystem.UserPojo.UserPojo;
import com.example.hotelmanagementsystem.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class LoginController {

    private final UserService userService;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("users", new User());
        return mav;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("users") User user ) {

        UserPojo authUser = userService.findByEmail(user.getEmail());
        UserPojo authUserPassword = userService.findByPassword(user.getPassword());


        System.out.print(authUser);
        System.out.print(authUserPassword);

        if(Objects.nonNull(authUser) && (Objects.nonNull(authUserPassword)))
        {
            return "redirect:/homepage";
        } else {
            return "redirect:/login";
        }
    }
}
