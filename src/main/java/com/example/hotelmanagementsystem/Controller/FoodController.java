package com.example.hotelmanagementsystem.Controller;
import com.example.hotelmanagementsystem.Services.FoodServices;
import com.example.hotelmanagementsystem.UserPojo.FoodPojo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order_food")
public class FoodController {
    private final FoodServices foodServices;
    @GetMapping("/order")
    public String OrderFood(Model model){
        model.addAttribute("order", new FoodPojo());
        return "/order_food_form";
    }
//    @PostMapping("/saveorder")
//    public String SaveOrder(@Valid FoodPojo foodPojo){
//        foodServices.save(foodPojo);
//        return "/order_food";
//    }


}
