package com.example.hotelmanagementsystem.Services;

import com.example.hotelmanagementsystem.UserPojo.CommentPojo;
import com.example.hotelmanagementsystem.entity.Blog_Comment;

import java.util.List;

public interface CommentServices {
    String save(CommentPojo commentPojo);
    List<Blog_Comment> fetchAll();
}
