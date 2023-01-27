package com.example.hotelmanagementsystem.Services;

import com.example.hotelmanagementsystem.UserPojo.CabPojo;
import com.example.hotelmanagementsystem.entity.Cab;

import java.util.List;


public interface CabService {
    String save_cab_record(CabPojo cabPojo);
    List<Cab> findAll();
    void deleteById(Integer id);
}
