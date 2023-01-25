package com.example.hotelmanagementsystem.Services.Impl;

import com.example.hotelmanagementsystem.Services.UserService;
import com.example.hotelmanagementsystem.UserPojo.*;
import com.example.hotelmanagementsystem.config.PasswordEncoderUtil;
import com.example.hotelmanagementsystem.entity.*;
import com.example.hotelmanagementsystem.exception.AppException;
import com.example.hotelmanagementsystem.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public final LaundaryRepo laundaryRepo;
    public final UserRepo userRepo;
    public final BookingRepo bookingRepo;
    public final ContactRepo contactRepo;
    public final FeedbackRepo feedbackRepo;
    public final BlogRepo blogRepo;






    @Override
    public String save(UserPojo userPojo) {
        User user = new User();
        user.setEmail(userPojo.getEmail());
        user.setFullname(userPojo.getFullname());
        user.setMobileNo(userPojo.getMobile_no());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userPojo.getPassword()));
        userRepo.save(user);
        return "created";
    }


    @Override
    public String save(BookingPojo bookingPojo) {
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
    public List<Feedback> fetchAllFeedback() {
        return this.feedbackRepo.findAll();
    }

    @Override
    public Booking fetchById(Integer id) {
        return bookingRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

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
    public List<Contact> fetchAllContact() {
        return this.contactRepo.findAll();
    }

    @Override
    public String submitLaundary(LaundaryPojo laundaryPojo) {
        Laundary laundary = new Laundary();
        laundary .setRoomno(laundaryPojo.getRoomno());
        laundary .setNoofclothes(laundaryPojo.getNoofclothes());
        laundary .setPrint(laundaryPojo.getPrint());
        laundaryRepo .save(laundary );
        return "sent";
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
    public UserPojo findByEmail(String email) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new AppException("Invalid User email", HttpStatus.BAD_REQUEST));
        return new UserPojo(user);
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



