package com.example.hotelmanagementsystem.Services.Impl;

import com.example.hotelmanagementsystem.Services.NoticesService;
import com.example.hotelmanagementsystem.UserPojo.NoticePojo;
import com.example.hotelmanagementsystem.entity.Notices;
import com.example.hotelmanagementsystem.repo.NoticeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticesService {
    private  final NoticeRepo noticeRepo;
    @Override
    public String save(NoticePojo noticePojo) {
        Notices notices=new Notices();
        if(noticePojo.getId()!=null){
            notices.setId(noticePojo.getId());
        }
        notices.setContent(noticePojo.getContent());
        notices.setTopic(noticePojo.getTopic());
        notices.setPublisher(noticePojo.getPublisher());
        notices.setDate_published(noticePojo.getDate_published());
        noticeRepo.save(notices);
        return "created";
    }

    @Override
    public List<Notices> fetchAll() {
        return this.noticeRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        noticeRepo.deleteById(id);
    }

    @Override
    public Notices fetchById(Integer id) {
        return noticeRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));

    }
}
