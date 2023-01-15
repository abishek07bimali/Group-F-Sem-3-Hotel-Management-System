package com.example.hotelmanagementsystem.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {
    @GetMapping("/coupleroom")
    public String getCouple() {
        return "coupleroom";
    }

    @GetMapping("/premiumroom")
    public String getDeluxe() {
        return "premiumroom";
    }

    @GetMapping("/masterroom")
    public String getMaster() {
        return "masterroom";
    }

    @GetMapping("/luxeroom")
    public String getLuxe() { return "luxeroom";
    }

    @GetMapping("/familyroom")
    public String getFanily() {
        return "familyroom";
    }

}
