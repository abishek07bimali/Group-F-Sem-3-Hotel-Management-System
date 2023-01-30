package com.example.hotelmanagementsystem;

import com.example.hotelmanagementsystem.entity.User;
import com.example.hotelmanagementsystem.entity.surprisePlanning;
import com.example.hotelmanagementsystem.repo.surprisePlanningRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class surprisePlanningRepositoryTests {
    @Autowired
    private surprisePlanningRepo surpriseplanningrepo;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveSurprisePlanningTest() {
        surprisePlanning surprise = surprisePlanning.builder()
                .startdate("2023/4/5")
                .build();
        surpriseplanningrepo.save(surprise);
        Assertions.assertThat(surprise.getUser_id()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getSurprisePlanningTest() {
        surprisePlanning surprise = surprisePlanning.builder()
                .startdate("2023/4/5")
                .build();
        surpriseplanningrepo.save(surprise);
        surprisePlanning surpriseCreated = surpriseplanningrepo.findById(surprise.getUser_id()).get();
        Assertions.assertThat(surpriseCreated.getUser_id()).isEqualTo(2);
    }

    @Test
    @Order(3)
    public void getListOfSurprisePlanningTest() {
        List<surprisePlanning> Surprises = surpriseplanningrepo.findAll();
        Assertions.assertThat(Surprises.size()).isGreaterThan(0);
    }


    @Test
    @org.springframework.core.annotation.Order(4)
    public void updateUserTest(){

        surprisePlanning surprise = surprisePlanning.builder()
                .startdate("2023/4/5")
                .build();
        surpriseplanningrepo.save(surprise);

        surprisePlanning surprise1  = surpriseplanningrepo.findById(surprise.getUser_id()).get();

        surprise1.setStartdate("2023/4/8");

        surprisePlanning surprisePlanningUpdated  = surpriseplanningrepo.save(surprise);

        Assertions.assertThat(surprisePlanningUpdated.getEnddate()).isEqualTo("2023/4/8");

    }

    @Test
    @Order(5)
    public void deleteUserTest(){

        surprisePlanning surprise = surprisePlanning.builder()
                .eventtype("birthday")
                .startdate("2023/4/5")
                .build();
        surpriseplanningrepo.save(surprise);


        surprisePlanning surprise1 = surpriseplanningrepo.findById(surprise.getUser_id()).get();
        surpriseplanningrepo.delete(surprise1);

        surprisePlanning surprise2 = null;
        Optional<surprisePlanning> optionalSurprise = surpriseplanningrepo.findByEventtype("2023/4/5");
        if(optionalSurprise.isPresent()){
            surprise2 = optionalSurprise.get();
        }

        Assertions.assertThat(surprise2).isNull();
//        Assertions.assertThat(User1.getId()).isNull();
    }
}

