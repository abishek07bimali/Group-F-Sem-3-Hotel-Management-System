package com.example.hotelmanagementsystem.Controller;

import com.example.hotelmanagementsystem.Services.BlogServices;
import com.example.hotelmanagementsystem.Services.UserService;
import com.example.hotelmanagementsystem.UserPojo.BlogPojo;
import com.example.hotelmanagementsystem.UserPojo.BookingPojo;
import com.example.hotelmanagementsystem.entity.Blog;
import com.example.hotelmanagementsystem.entity.Booking;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final BlogServices blogServices;

    @GetMapping("/list")
    public String getUserList(Model model) {
        List<Booking> bookings = userService.fetchAll();
        model.addAttribute("bookinglist", bookings);
        return "viewCustomerlist";
    }



    @GetMapping("/newbooking")
    public String BookHotel(Model model) {
        model.addAttribute("newBooking", new BookingPojo());
        return "newbookings";
    }



    @PostMapping("/savenewbook")
    public String saveBooking(@Valid BookingPojo bookingPojo) {
        userService.save(bookingPojo);
        return "redirect:/admin/list";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model) {
        Booking booking = userService.fetchById(id);
        model.addAttribute("newBooking", new BookingPojo(booking));
        return "newbookings";
    }


    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.deleteById(id);
        return "redirect:/admin/list";
    }



//
//
//    ----------------------------------------------------------------------
//               blog page
//    --------------------------------------------------------------
//    @GetMapping("/adminBlogPage")
//    public  String getPage(){
//        return "adminBlogPage";
//    }


    @GetMapping("/bloglist")
    public String getBlogList(Model model){
        List<Blog> blogs = blogServices.fetchAll();
        model.addAttribute("blog", blogs);
        return "adminBlogPage";
    }

    @GetMapping("/newblog")
    public String AddBlog(Model model) {
        model.addAttribute("blog", new BlogPojo());
        return "admin_blog";
    }

    @PostMapping("/saveblog")
    public String saveBlog(@Valid BlogPojo blogPojo) {
        blogServices.save(blogPojo);
        return "redirect:/admin/bloglist";
    }
    @GetMapping("/editblog/{id}")
    public String editBlog(@PathVariable("id") Integer id, Model model) {
        Blog blog = blogServices.fetchById(id);
        model.addAttribute("newBooking", new BlogPojo(blog));
        return "admin_blog";
    }


    @GetMapping("/deleteblog/{id}")
    public String deleteBlog(@PathVariable("id") Integer id) {
        blogServices.deleteById(id);
        return "redirect:/admin/bloglist";
    }



}
