package com.example.hotelmanagementsystem;

import com.example.hotelmanagementsystem.entity.Cab;
import com.example.hotelmanagementsystem.repo.CabRepo;
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
public class CabRepositoryTest {

    @Autowired
    private CabRepo cabRepo;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveBookingTest() {


        Cab cab = Cab.builder()
                .fullname("rak")
                .car("ford")
                .date("2023/1/3")
                .build();
        cabRepo.save(cab);

//        Assumption of the above datta

        Assertions.assertThat(cab.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getBookingTest() {

        Cab cab = Cab.builder()
                .fullname("rak")
                .car("ford")
                .date("2023/1/3")
                .build();
        cabRepo.save(cab);


        Cab cabCreated = cabRepo.findById(cab.getId()).get();
        Assertions.assertThat(cabCreated.getId()).isEqualTo(cab.getId());

    }

    @Test
    @Order(3)
    public void getListOfBookingTest(){
        Cab cab = Cab.builder()
                .fullname("rak")
                .car("ford")
                .date("2023/1/3")
                .build();
        cabRepo.save(cab);
        
        List<Cab> Cab = cabRepo.findAll();
        Assertions.assertThat(Cab.size()).isGreaterThan(0);
    }


    @Test
    @Order(4)
    public void updateBookingTest(){

        Cab cab = Cab.builder()
                .fullname("rak")
                .car("ford")
                .date("2023/1/3")
                .build();
        cabRepo.save(cab);

        Cab cab1  = cabRepo.findById(cab.getId()).get();

        cab1.setFullname("new name");

        Cab cabUpdated  = cabRepo.save(cab);

        Assertions.assertThat(cabUpdated.getFullname()).isEqualTo("new name");

    }

    @Test
    @Order(5)
    public void deleteBookingTest(){

        Cab cab = Cab.builder()
                .fullname("rak")
                .car("ford")
                .date("2023/1/3")
                .build();
        cabRepo.save(cab);

//        @Query(value = "SELECT * from")

        Cab cab1 = cabRepo.findById(cab.getId()).get();
        cabRepo.delete(cab1);

        Cab cab2 = null;
        Optional<Cab> optionalCab = cabRepo.findCabByFullname("rak");
        if(optionalCab.isPresent()){
            cab2 = optionalCab.get();
        }

        Assertions.assertThat(cab2).isNull();
//        Assertions.assertThat(cab1.getId()).isNull();
    }

}
