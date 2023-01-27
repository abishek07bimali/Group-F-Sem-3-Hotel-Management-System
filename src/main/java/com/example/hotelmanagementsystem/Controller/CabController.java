package com.example.hotelmanagementsystem.Controller;

import com.example.hotelmanagementsystem.UserPojo.CabPojo;
import com.example.hotelmanagementsystem.Services.CabService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cab")
public class CabController {
    private final CabService cabService;
    @GetMapping("/book")
    public String BookCab(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        model.addAttribute("cab",new CabPojo());
        return "book_cab";
    }
    @PostMapping("/save")
    public String SaveCab(CabPojo cabPojo){
        cabService.save_cab_record(cabPojo);
        return"redirect:/homepage";
    }
}
