package com.example.hotelmanagementsystem.Services.Impl;

import com.example.hotelmanagementsystem.entity.Cab;
import com.example.hotelmanagementsystem.UserPojo.CabPojo;
import com.example.hotelmanagementsystem.repo.CabRepo;
import com.example.hotelmanagementsystem.Services.CabService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CabServiceImpl implements CabService {
    public final CabRepo cabRepo;
    @Override
    public String save_cab_record(CabPojo cabPojo) {
        Cab cab = new Cab();
        cab.setFullname(cabPojo.getFullname());
        cab.setPhone(cabPojo.getPhone());
        cab.setCar(cabPojo.getCar());
        cab.setPeople(cabPojo.getPeople());
        cab.setDate(cabPojo.getDate());
        cab.setTime(cabPojo.getTime());
        cabRepo.save(cab);
        return "created";
    }
}
