package com.example.hotelmanagementsystem.Services.Impl;

import com.example.hotelmanagementsystem.Services.UserService;
import com.example.hotelmanagementsystem.UserPojo.*;
import com.example.hotelmanagementsystem.config.PasswordEncoderUtil;
import com.example.hotelmanagementsystem.entity.*;
import com.example.hotelmanagementsystem.exception.AppException;
import com.example.hotelmanagementsystem.repo.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import java.nio.charset.StandardCharsets;
import java.util.*;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public final LaundaryRepo laundaryRepo;
    public final surprisePlanningRepo surpriseplanningRepo;
    public final UserRepo userRepo;
    public final BookingRepo bookingRepo;
    public final ContactRepo contactRepo;
    public final FeedbackRepo feedbackRepo;
    public final CommentRepo commentRepo;
    private final JavaMailSender getJavaMailSender;
    public final BlogRepo blogRepo;
    public final SocialMediaRepo socialMediaRepo;
    private final ThreadPoolTaskExecutor taskExecutor;
    @Autowired
    @Qualifier("emailConfigBean")
    private Configuration emailConfig;
    @Override
    public void sendEmail() {
        try {
            Map<String, String> model = new HashMap<>();

            MimeMessage message = getJavaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

            Template template = emailConfig.getTemplate("emailTemp.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

            mimeMessageHelper.setTo("sendfrom@yopmail.com");
            mimeMessageHelper.setText(html, true);
            mimeMessageHelper.setSubject("Registration");
            mimeMessageHelper.setFrom("sendTo@yopmail.com");

            taskExecutor.execute(new Thread() {
                public void run() {
                    getJavaMailSender.send(message);
                }
            });
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public String save(UserPojo userPojo) {
        User user = new User();
        if(userPojo.getId()!=null){
            user.setId(userPojo.getId());
        }
        user.setEmail(userPojo.getEmail());
        user.setFullname(userPojo.getFullname());
        user.setMobileNo(userPojo.getMobile_no());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userPojo.getPassword()));
        userRepo.save(user);
        return "created";
    }

    @Override
    public String update(UserPojo userPojo) {
        User user = new User();
        if(userPojo.getId()!=null){
            user.setId(userPojo.getId());
        }
        user.setEmail(userPojo.getEmail());
        user.setFullname(userPojo.getFullname());
        user.setMobileNo(userPojo.getMobile_no());
        userRepo.save(user);
        return "created";
    }


    @Override
    public String save(BookingPojo bookingPojo) {
        User relateduser = userRepo.findById(bookingPojo.getUser_id())
                .orElseThrow(() -> new AppException("Invalid id for user type", HttpStatus.BAD_REQUEST));

        Booking booking=new Booking();
        if(bookingPojo.getId()!=null){
            booking.setId(bookingPojo.getId());
        }
        booking.setFullname(bookingPojo.getFullname());
        booking.setNumber_of_people(bookingPojo.getNumber_of_people());
        booking.setMobileNo(bookingPojo.getMobile_no());
        booking.setCheckin(bookingPojo.getCheckin());
        booking.setCheckout(bookingPojo.getCheckout());
        booking.setDate(bookingPojo.getDate());
        booking.setTotal(bookingPojo.getAmount());
        booking.setRooms(bookingPojo.getRoom());
        booking.setUser_id(relateduser);
        bookingRepo.save(booking);
        return null;
    }
    @Override
    public String saveAdmin(AdminBooking adminBooking) {
//        User relateduser = userRepo.findById(bookingPojo.getUser_id())
//                .orElseThrow(() -> new AppException("Invalid id for user type", HttpStatus.BAD_REQUEST));

        Booking booking=new Booking();
        if(adminBooking.getId()!=null){
            booking.setId(adminBooking.getId());
        }
        booking.setFullname(adminBooking.getFullname());
        booking.setNumber_of_people(adminBooking.getNumber_of_people());
        booking.setMobileNo(adminBooking.getMobile_no());
        booking.setCheckin(adminBooking.getCheckin());
        booking.setCheckout(adminBooking.getCheckout());
        booking.setDate(adminBooking.getDate());
        booking.setTotal(adminBooking.getAmount());
        booking.setRooms(adminBooking.getRoom());
//        booking.setUser_id(relateduser);
        bookingRepo.save(booking);
        return null;
    }



    @Override
    public String submitMsg(ContactPojo contactPojo) {
        Contact contact=new Contact();
        contact.setFullname(contactPojo.getFullname());
        contact.setEmail(contactPojo.getEmail());
        contact.setSubject(contactPojo.getSubject());
        contact.setMessage(contactPojo.getMessage());
        contactRepo.save(contact);
        return "sent";
    }

    @Override
    public String submitFeedback(FeedbackPojo feedbackPojo){
        Feedback feedback = new Feedback();
        feedback.setFullname(feedbackPojo.getFullname());
        feedback.setEmail(feedbackPojo.getEmail());
        feedback.setSubject(feedbackPojo.getSubject());
        feedback.setMessage(feedbackPojo.getMessage());
        feedbackRepo.save(feedback);
        return "sent";
    }

    @Override
    public String submitPlanning(surprisePlanningPojo surpriseplanningPojo) {
        surprisePlanning surpriseplanning = new surprisePlanning();
        surpriseplanning.setStartdate(surpriseplanningPojo.getStartdate());
        surpriseplanning.setEnddate(surpriseplanningPojo.getEnddate());
        surpriseplanning.setEventtype(surpriseplanningPojo.getEventtype());
        surpriseplanning.setEventspace(surpriseplanningPojo.getEventspace());
        surpriseplanning.setEventdescription(surpriseplanningPojo.getEventdescription());
        surpriseplanningRepo.save(surpriseplanning);
        return "submitted";
    }
    public List<Feedback> fetchAllFeedback() {
        return this.feedbackRepo.findAll();
    }

    @Override
    public List<Booking> findApplicationById(Integer id) {
        return bookingRepo.findApplicationById(id);
    }

    @Override
    public Booking fetchById(Integer id) {
        return bookingRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public User getById(Integer id) {
        return userRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

//    @Override
//    public User getById(Integer id) {
//        User user= userRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
//        user=User.builder()
//                .id(user.getId())
//                .fullname(user.getFullname())
//                .email(user.getEmail())
//                .mobileNo(user.getMobileNo())
//                .build();
//        return user;    }

//    public List<Booking> getByKeyword(String keyword){
//        return bookingRepo.findByKeyword(keyword);
//    }

    public List<Booking> fetchAll(){
        return this.bookingRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        bookingRepo.deleteById(id);
    }

    @Override
    public void deleteFeedback(Integer id) {
        feedbackRepo.deleteById(id);
    }

    @Override
    public void deletecomment(Integer id) {
        commentRepo.deleteById(id);
    }


    @Override
    public List<Contact> fetchAllContact() {
        return this.contactRepo.findAll();
    }


    @Override
    public String save(LaundaryPojo laundaryPojo) {
        Laundary laundary=new Laundary();
        if(laundaryPojo.getId()!=null) {
            laundary.setId(laundaryPojo.getId());
        }
        laundary.setRoomno(laundaryPojo.getRoomno());
        laundary.setNoofclothes(laundaryPojo.getNoofclothes());
        laundary.setPrice(laundaryPojo.getPrice());
        laundaryRepo.save(laundary );
        return null;

    }


 




    public String save(BlogPojo blogPojo) {
        Blog blog =new Blog();
        if(blogPojo.getId()!=null){
            blog.setId(blogPojo.getId());
        }
        blog.setAuthor(blogPojo.getAuthor());
        blog.setTopic(blogPojo.getTopic());
        blog.setDate(blogPojo.getDate());
        blog.setPhoneNum(blogPojo.getPhoneNum());
        blog.setContent(blogPojo.getContent());
//        blog.setImg(blogPojo.getImg());
        blogRepo.save(blog);
        return null;
    }

    @Override
    public User findByEmail(String email) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new AppException("Invalid User email", HttpStatus.BAD_REQUEST));
        return user;
    }


    @Override
    public void processPasswordResetRequest(String email) {
        Optional<User> optionalUser = userRepo.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            String OTP = generateOTP();
            user.setOTP(OTP);
            userRepo.save(user);
            sendOTPEmail(email, OTP);
        }
    }

    @Override
    public void resetPassword(String email, String OTP, String password) {
        User user = userRepo.findByEmailAndOTP(email, OTP);
        if (user != null) {
            if (password == null) {
                throw new IllegalArgumentException("Password cannot be null");
            }
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(password);
            user.setPassword(encodedPassword);
            user.setOTP(null);
            userRepo.save(user);
        } else {
            throw new RuntimeException();
        }
    }

    private String generateOTP() {
        return String.format("%06d", new Random().nextInt(1000000));
    }

    private void sendOTPEmail(String email, String OTP) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Password Reset OTP");
        message.setText("Your OTP for resetting your password is: " + OTP);
        getJavaMailSender.send(message);
    }
//    @Override
//    public Page<Booking> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
//        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
//                Sort.by(sortField).descending();
//
//        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
//        return this.bookingRepo.findAll(pageable);
//    }
}
