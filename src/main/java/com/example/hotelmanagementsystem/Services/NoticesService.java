package com.example.hotelmanagementsystem.Services;

import com.example.hotelmanagementsystem.UserPojo.NoticePojo;
import com.example.hotelmanagementsystem.entity.Notices;

import java.util.List;

public interface NoticesService {
    String save(NoticePojo noticePojo);
    List<Notices> fetchAll();
    void deleteById(Integer id);
    Notices fetchById(Integer id);

}
