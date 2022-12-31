package com.example.hotelmanagementsystem.Controller;



import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

//    private final UserService userService;

    @GetMapping("/create")
    public String getRegisterPage() {
        return "homepage";
    }

}
//

//    @GetMapping("/list")
//    public String getUserList(Model model) {
//        List<User> users = userService.fetchAll();
//        model.addAttribute("userlist", users);
//        return "user/index";
//    }
//
//    @GetMapping("/create")
//    public String createUser(Model model) {
//        model.addAttribute("user", new UserPojo());
//        return "user/create";
//    }
//
//    @PostMapping("/save")
//    public String saveUser(@Valid UserPojo userpojo) {
//        userService.save(userpojo);
//        return "redirect:/user/list";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String editUser(@PathVariable("id") Integer id, Model model) {
//        User user = userService.fetchById(id);
//        model.addAttribute("user", new UserPojo(user));
//        return "user/create";
//    }
//}
