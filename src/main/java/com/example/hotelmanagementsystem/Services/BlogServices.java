package com.example.hotelmanagementsystem.Services;

import com.example.hotelmanagementsystem.UserPojo.BlogPojo;
import com.example.hotelmanagementsystem.entity.Blog;

import java.util.List;

public interface BlogServices {
    String save(BlogPojo blogPojo);
    List<Blog> fetchAll();

    Blog fetchById(Integer id);
    void deleteById(Integer id);


}
