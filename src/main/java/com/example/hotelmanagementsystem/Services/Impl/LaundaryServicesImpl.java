package com.example.hotelmanagementsystem.Services.Impl;

import com.example.hotelmanagementsystem.Services.LaundaryServices;
import com.example.hotelmanagementsystem.UserPojo.LaundaryPojo;
import com.example.hotelmanagementsystem.entity.Laundary;
import com.example.hotelmanagementsystem.repo.LaundaryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LaundaryServicesImpl implements LaundaryServices {
    private  final LaundaryRepo laundaryRepo;


    @Override
    public String save(LaundaryPojo laundaryPojo) {
        Laundary laundary =new Laundary();
        if(laundaryPojo.getId()!=null){
            laundary.setId(laundaryPojo.getId());
        }
        laundary.setRoomno(laundaryPojo.getRoomno());
        laundary.setNoofclothes(laundaryPojo.getNoofclothes());
        laundary.setPrice(laundaryPojo.getPrice());
        laundaryRepo.save(laundary);
        return null;
    }


    @Override
    public List<Laundary> fetchAll() {
        return laundaryRepo.findAll();

    }

    @Override
    public Laundary fetchById(Integer id) {
        return laundaryRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));

    }

    @Override
    public void deleteById(Integer id) {
        laundaryRepo.deleteById(id);
    }

}
