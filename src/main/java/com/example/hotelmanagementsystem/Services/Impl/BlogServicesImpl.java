package com.example.hotelmanagementsystem.Services.Impl;

import com.example.hotelmanagementsystem.Services.BlogServices;
import com.example.hotelmanagementsystem.UserPojo.BlogPojo;
import com.example.hotelmanagementsystem.entity.Blog;
import com.example.hotelmanagementsystem.repo.BlogRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServicesImpl implements BlogServices {
    private  final BlogRepo blogRepo;

    @Override
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
    public List<Blog> fetchAll() {
        return this.blogRepo.findAll();

    }

    @Override
    public Blog fetchById(Integer id) {
        return blogRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));

    }

    @Override
    public void deleteById(Integer id) {
        blogRepo.deleteById(id);
    }

}
