package com.example.hotelmanagementsystem.Services.Impl;

import com.system.web_backend_individual1.Entity.Cab;
import com.system.web_backend_individual1.Pojo.CabPojo;
import com.system.web_backend_individual1.Repo.CabRepo;
import com.system.web_backend_individual1.Services.CabService;
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
