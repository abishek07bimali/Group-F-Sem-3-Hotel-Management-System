package com.example.hotelmanagementsystem.Services;

import com.example.hotelmanagementsystem.UserPojo.LaundaryPojo;
import com.example.hotelmanagementsystem.entity.Laundary;

import java.util.List;

public interface LaundaryServices {
    String save(LaundaryPojo laundaryPojo);
    List<Laundary> fetchAll();
    Laundary fetchById(Integer id);

    void deleteLaundary(Integer id);
}
