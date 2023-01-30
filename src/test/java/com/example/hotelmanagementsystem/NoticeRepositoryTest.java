package com.example.hotelmanagementsystem;


import com.example.hotelmanagementsystem.entity.Blog;
import com.example.hotelmanagementsystem.entity.Notices;
import com.example.hotelmanagementsystem.repo.NoticeRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NoticeRepositoryTest {
    @Autowired
    private NoticeRepo noticeRepo;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveContactTest() {

        Notices notice = Notices.builder()
                .topic("breaking news")
                .content("asudh asubdh")
                .build();

        noticeRepo.save(notice);

        Assertions.assertThat(notice.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getContactTest() {

        Notices notice = Notices.builder()
                .topic("breaking news")
                .content("asudh asubdh")
                .build();

        noticeRepo.save(notice);

        Notices noticeCreated = noticeRepo.findById(notice.getId()).get();
        Assertions.assertThat(noticeCreated.getId()).isEqualTo(notice.getId());

    }

    @Test
    @Order(3)
    public void getListOfContactTest(){
        Notices notice = Notices.builder()
                .topic("breaking news")
                .content("asudh asubdh")
                .build();

        noticeRepo.save(notice);
        List<Notices> User = noticeRepo.findAll();
        Assertions.assertThat(User.size()).isGreaterThan(0);
    }


    @Test
    @Order(4)
    public void updateContactTest(){

        Notices notice = Notices.builder()
                .topic("breaking news")
                .content("asudh asubdh")
                .build();

        noticeRepo.save(notice);

        Notices notice1  = noticeRepo.findById(notice.getId()).get();

        notice1.setTopic("new topic");

        Notices noticeUpdated  = noticeRepo.save(notice);

        Assertions.assertThat(noticeUpdated.getTopic()).isEqualTo("new topic");

    }

    @Test
    @Order(5)
    public void deleteContactTest(){

        Notices notice = Notices.builder()
                .topic("topic")
                .content("asudh asubdh")
                .build();

        noticeRepo.save(notice);

//        @Query(value = "SELECT * from")

        Notices notice1 = noticeRepo.findById(notice.getId()).get();
        noticeRepo.delete(notice1);

        Notices notice2 = null;
        Optional<Notices> optionalBlog = noticeRepo.findNoticesByTopic("topic");
        if(optionalBlog.isPresent()){
            notice2 = optionalBlog.get();
        }

        Assertions.assertThat(notice2).isNull();

    }


}
