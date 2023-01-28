package com.example.hotelmanagementsystem.Controller;

import com.example.hotelmanagementsystem.Services.*;
import com.example.hotelmanagementsystem.Services.Impl.Comment;
import com.example.hotelmanagementsystem.UserPojo.*;
import com.example.hotelmanagementsystem.entity.*;
import com.example.hotelmanagementsystem.repo.BookingRepo;
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
    private  final BookingRepo bookingRepo;
    private  final CabService cabService;
    private  final Comment comment;

    private final SocialMediaServices socialMediaServices;

    @GetMapping("/list")
    public String getUserList( Model model) {
        List<Booking> bookings = userService.fetchAll();
        model.addAttribute("bookinglist", bookings);
        return "viewCustomerlist";
    }

//    @GetMapping("/page/{pageNo}")
//    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
//                                @RequestParam("sortField") String sortField,
//                                @RequestParam("sortDir") String sortDir,
//                                Model model) {
//        int pageSize = 7;
//
//        Page<Booking> page = userService.findPaginated(pageNo, pageSize, sortField, sortDir);
//        List<Booking> bookings = page.getContent();
//
//        model.addAttribute("currentPage", pageNo);
//        model.addAttribute("totalPages", page.getTotalPages());
//        model.addAttribute("totalItems", page.getTotalElements());
//
//        model.addAttribute("sortField", sortField);
//        model.addAttribute("sortDir", sortDir);
//        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
//
//        model.addAttribute("bookinglist", bookings);
//        return "viewCustomerlist";
//    }
//    @GetMapping("/list")
//    public String viewHomePage(Model model) {
//        return findPaginated(1, "fullname", "asc", model);
//    }




//    @Autowired
//    private UserService service;
//    @RequestMapping(path = {"/","/list"})
//    public String home(Model model, String keyword) {
//        if(keyword!=null) {
//            List<Booking> bookings = service.getByKeyword(keyword);
//            model.addAttribute("bookinglist", bookings);
//        }else {
//            List<Booking> bookings = service.fetchAll();
//            model.addAttribute("bookinglist", bookings);
//        }
//        return "viewCustomerlist";
//    }

//
//    @GetMapping("/alllist")
//    public String getAllBooking(Model model) {
//        List<Booking> bookings = userService.fetchAll();
//        model.addAttribute("bookinglist", bookings);
//        return "Admin/AllBooking";
//    }
//
//    -----------------
//    view contactfetch
//    -----------
//

    @GetMapping("/contactfetch")
    public String getContactAdmin(Model model) {
        List<Contact> contact = userService.fetchAllContact();
        model.addAttribute("contactlist", contact);
        List<Feedback> feedbacks = userService.fetchAllFeedback();
        model.addAttribute("feedback", feedbacks);
        List<Blog_Comment> blogComments = comment.fetchAll();
        model.addAttribute("comment", blogComments);
        return "Admin/ViewContactandFeedback";
    }

    //


    @GetMapping("/newbooking")
    public String BookHotel(Model model) {
        model.addAttribute("newBooking", new AdminBooking());
        return "newbookings";
    }



    @PostMapping("/savenewbook")
    public String saveBooking(@Valid AdminBooking adminBooking) {
        userService.saveAdmin(adminBooking);
        return "redirect:/admin/list";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model) {
        Booking booking = userService.fetchById(id);
        model.addAttribute("newBooking", new AdminBooking(booking));
        return "newbookings";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.deleteById(id);
        return "redirect:/admin/list";
    }


    @GetMapping("/bill/{id}")
    public String getBill(@PathVariable("id") Integer id, Model model) {
        Booking booking = userService.fetchById(id);
        model.addAttribute("bill", new AdminBooking(booking));
        return "PrintBill";
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
        return "admin_blog";
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
        return ("notice-form");
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
    @GetMapping("/deleteImg/{id}")
    public String delImg(@PathVariable("id") Integer id) {
        galleryServices.deleteById(id);
        return "redirect:/admin/viewImage";
    }

//
//
//------------------------------------------------------------
//  Cab Booking
//
//
//    -------------------------------------------------------------

    @GetMapping("/cabBookingByCustomer")
    public String getCabBooking(Model model) {
        List<Cab> cabs = cabService.findAll();
        model.addAttribute("cab", cabs);
        return "Admin/ViewCabBooking";
    }


    @GetMapping("/deletecab/{id}")
    public String detCab(@PathVariable("id") Integer id) {
        cabService.deleteById(id);
        return "redirect:/admin/cabBookingByCustomer";
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

    @GetMapping("/ViewSocailLinks")
    public String getMediaForm(Model model){
        model.addAttribute("socialLink", new SocialMediaPojo());
        List<SocialMedia> socialMedia = socialMediaServices.fetchAll();
        model.addAttribute("medialink", socialMedia);
        return "media-linkForm";
    }
//    @GetMapping("/socialmedia_form")
//    public String getMediaLink(Model model){
//        model.addAttribute("socialLink", new SocialMediaPojo());
//        return "Admin/AddLinks";
//    }

    @GetMapping("/editSocialMediaLink/{id}")
    public String editMediaLink(@PathVariable("id") Integer id, Model model) {
        SocialMedia socialMedia = socialMediaServices.fetchById(id);
        model.addAttribute("socialLink", new SocialMediaPojo(socialMedia));
        return "Admin/AddLinks";
    }

//
    @PostMapping("/savemedialink")
    public String saveMediaLink(@Valid SocialMediaPojo socialMediaPojo) {
        socialMediaServices.save(socialMediaPojo);
        return "redirect:/admin/ViewSocailLinks";
    }



//    ---------------------------------------
//    -------  Admin Profile ----------------
//    ---------------------------------------

    @GetMapping("/admin_profile")
    public String getAdminProfile(Model model){
        return "adminProfile";
    }
}
