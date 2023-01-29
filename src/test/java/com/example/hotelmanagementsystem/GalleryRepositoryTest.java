package com.example.hotelmanagementsystem;

import com.example.hotelmanagementsystem.entity.Gallery;
import com.example.hotelmanagementsystem.repo.GalleryRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GalleryRepositoryTest {


    @Autowired
    private GalleryRepo galleryRepo;


    @Test
    @Order(1)
    public void saveContactTest() {


        Gallery gallery = Gallery.builder()
                .name("image")
                .build();

        galleryRepo.save(gallery);

        Assertions.assertThat(gallery.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getContactTest() {

        Gallery gallery = Gallery.builder()
                .name("image")
                .build();

        galleryRepo.save(gallery);


        Gallery  galleryCreated = galleryRepo.findById(gallery.getId()).get();
        Assertions.assertThat(galleryCreated.getId()).isEqualTo(gallery.getId());

    }

    @Test
    @Order(3)
    public void getListOfContactTest(){
        Gallery gallery = Gallery.builder()
                .name("image")
                .build();

        galleryRepo.save(gallery);
        List<Gallery> User = galleryRepo.findAll();
        Assertions.assertThat(User.size()).isGreaterThan(0);
    }


    @Test
    @Order(4)
    public void updateContactTest(){

        Gallery gallery = Gallery.builder()
                .name("image")
                .build();

        galleryRepo.save(gallery);

        Gallery  gallery1  = galleryRepo.findById(gallery.getId()).get();

        gallery1.setName("b@g.com");

        Gallery  galleryUpdated  = galleryRepo.save(gallery);

        Assertions.assertThat(galleryUpdated.getName()).isEqualTo("b@g.com");

    }

    @Test
    @Order(5)
    public void deleteContactTest(){

        Gallery gallery = Gallery.builder()
                .name("image")
                .build();

        galleryRepo.save(gallery);

//        @Query(value = "SELECT * from")

        Gallery  gallery1 = galleryRepo.findById(gallery.getId()).get();
        galleryRepo.delete(gallery1);

        Gallery  gallery2 = null;
        Optional<Gallery> optionalGallery = galleryRepo.findGalleryByName("a@g.com");
        if(optionalGallery.isPresent()){
            gallery2 = optionalGallery.get();
        }

        Assertions.assertThat(gallery2).isNull();
//        Assertions.assertThat(User1.getId()).isNull();
    }


}
