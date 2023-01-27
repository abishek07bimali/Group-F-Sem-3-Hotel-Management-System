package com.example.hotelmanagementsystem.Controller;

import com.example.hotelmanagementsystem.Services.*;
import com.example.hotelmanagementsystem.UserPojo.*;
import com.example.hotelmanagementsystem.entity.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final BlogServices blogServices;
    private  final NoticesService noticesService;
    private  final GalleryServices galleryServices;

    private final SocialMediaServices socialMediaServices;

    @GetMapping("/list")
    public String getUserList(Model model) {
        List<Booking> bookings = userService.fetchAll();
        model.addAttribute("bookinglist", bookings);
        return "viewCustomerlist";
    }


    @GetMapping("/alllist")
    public String getAllBooking(Model model) {
        List<Booking> bookings = userService.fetchAll();
        model.addAttribute("bookinglist", bookings);
        return "Admin/AllBooking";
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


//    @GetMapping("/adminblogpage")
//    public  String getPage(){
//        return "adminBlogPage";
//    }

//
//
//    ----------------------------------------------------------------------
//               blog page
//    --------------------------------------------------------------
//    @GetMapping("/adminBlogPage")
//    public  String getPage(){
//        return "adminBlogPage";
//    }

//    AdminBlog page
    @GetMapping("/bloglist")
    public String getBlogList(Model model){
        List<Blog> blogs = blogServices.fetchAll();
        List<Notices> notices = noticesService.fetchAll();
        model.addAttribute("blog", blogs);
        model.addAttribute("notice", notices);
        return "adminBlogPage";
    }

    @GetMapping("/addblog")
    public String AddBlog(Model model) {
        model.addAttribute("blog", new BlogPojo());
        return "admin_blog";
    }

    @PostMapping("/saveblog")
    public String saveBlog(@Valid BlogPojo blogPojo) {
                blogServices.save(blogPojo);
        return "redirect:/admin/bloglist";
//    }
//        userService.save(blogPojo);
//        return "redirect:adminBlogPage";
    }

    @GetMapping("/dashboard")
    public String getAdmin(Model model) {
        return "daily_profit";
    }

    @GetMapping("/editblog/{id}")
    public String editBlog(@PathVariable("id") Integer id, Model model) {
        Blog blog = blogServices.fetchById(id);
        model.addAttribute("blog", new BlogPojo(blog));
        return "redirect:/admin/addblog";
    }


    @GetMapping("/deleteblog/{id}")
    public String deleteBlog(@PathVariable("id") Integer id) {
        blogServices.deleteById(id);
        return "redirect:/admin/bloglist";
    }



    @GetMapping("/noticeform")
    public String getNotice( Model model) {
        model.addAttribute("blog", new NoticePojo());
        return ("notice-form");
    }

    @PostMapping("/noticeAdd")
    public String saveNotice(@Valid NoticePojo noticePojo) {
        noticesService.save(noticePojo);
        return "redirect:/admin/bloglist";
    }


    @GetMapping("/editnotice/{id}")
    public String editNotice(@PathVariable("id") Integer id, Model model) {
        Notices notice = noticesService.fetchById(id);
        model.addAttribute("notice", new NoticePojo(notice));
        return "redirect:/admin/noticeform";
    }

//gallery controller

    @GetMapping("/addImage")
    public String getGallery(Model model) {
        model.addAttribute("gallery", new GalleryPojo());
        return "add_image";
    }


    @PostMapping("/addgallery")
    public String createUser(@Valid GalleryPojo galleryPojo,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {

        Map<String, String> requestError = validateRequest(bindingResult);
        if (requestError != null) {
            redirectAttributes.addFlashAttribute("requestError", requestError);
            return "redirect:/admin/addImage";
        }

        galleryServices.save(galleryPojo);
        redirectAttributes.addFlashAttribute("successMsg", "Image saved successfully");

        return "redirect:/admin/viewImage";
    }

    @GetMapping("/viewImage")
    public String addGallery( Model model) {
        List<Gallery> gallerys = galleryServices.fetchAll();
        model.addAttribute("imagelist", gallerys.stream().map(gallery ->
                Gallery.builder()
                        .id(gallery.getId())
                        .name(gallery.getName())
                        .imageBase64(getImageBase64(gallery.getImage()))
                        .build()

        ));
        return "Admin/ViewImages";
    }


    public Map<String, String> validateRequest(BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            return null;
        }
        Map<String, String> errors = new HashMap<>();
        bindingResult.getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return errors;

    }

    public String getImageBase64(String fileName) {
        String filePath = System.getProperty("user.dir") + "/Gallery/";
        File file = new File(filePath + fileName);
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;
    }

//    ----------------
//        Media link form
//    ----------------
//    ----------- Admin Side -----------
//    ----------------------------------

//    @GetMapping("/socialmedia_form")
//    public String getMediaForm(Model model){
//        return "media-linkForm";
//    }

//    @GetMapping("/editblog/{id}")
//    public String editMediaLink(@PathVariable("id") Integer id, Model model) {
//        SocialMedia socialMedia = socialMediaServices.fetchById(id);
//        model.addAttribute("blog", new SocialMediaPojo(socialMedia));
//        return "redirect:/admin/socialmeadia_Form";
//    }
//
//
//    @PostMapping("/savemedialink")
//    public String saveMediaLink(@Valid SocialMediaPojo socialMediaPojo) {
//        socialMediaServices.save(socialMediaPojo);
//        return "redirect:/admin/bloglist";
//    }



//    ---------------------------------------
//    -------  Admin Profile ----------------
//    ---------------------------------------

    @GetMapping("/admin_profile")
    public String getAdminProfile(Model model){
        return "adminProfile";
    }
}
