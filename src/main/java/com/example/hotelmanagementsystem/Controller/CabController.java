package com.example.hotelmanagementsystem.Controller;

import com.system.web_backend_individual1.Pojo.CabPojo;
import com.system.web_backend_individual1.Services.CabService;
import lombok.RequiredArgsConstructor;
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
        model.addAttribute("cab",new CabPojo());
        return "book_cab";
    }
    @PostMapping("/cab/save")
    public String SaveCab(CabPojo cabPojo){
        cabService.save_cab_record(cabPojo);
        return"dashboard";
    }
}
