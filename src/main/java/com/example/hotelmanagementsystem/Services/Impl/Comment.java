package com.example.hotelmanagementsystem.Services.Impl;

import com.example.hotelmanagementsystem.Services.CommentServices;
import com.example.hotelmanagementsystem.UserPojo.CommentPojo;
import com.example.hotelmanagementsystem.entity.Blog_Comment;
import com.example.hotelmanagementsystem.repo.CommentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Comment implements CommentServices {
    private final CommentRepo commentRepo;
    @Override
    public String save(CommentPojo commentPojo) {
//        Blog_Comment relateduser = commentRepo.findById(commentPojo.getBlog_id())
//                .orElseThrow(() -> new AppException("Invalid id for user type", HttpStatus.BAD_REQUEST));

        Blog_Comment booking=new Blog_Comment();
        if(commentPojo.getId()!=null){
            booking.setId(commentPojo.getId());
        }
        booking.setFullname(commentPojo.getFullname());
        booking.setComment(commentPojo.getComment());
        booking.setEmail(commentPojo.getEmail());
//        booking.setBlogId(commentRepo.findById(commentPojo.getBlog_id()).orElseThrow().getBlogId());
        commentRepo.save(booking);
        return null;
    }

    @Override
    public List<Blog_Comment> fetchAll() {
        return this.commentRepo.findAll();
    }
}
