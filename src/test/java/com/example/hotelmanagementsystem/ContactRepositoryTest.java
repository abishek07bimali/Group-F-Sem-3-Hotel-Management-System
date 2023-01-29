package com.example.hotelmanagementsystem;


import com.example.hotelmanagementsystem.entity.Contact;
import com.example.hotelmanagementsystem.repo.ContactRepo;
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
public class ContactRepositoryTest {

    @Autowired
    private ContactRepo contactRepo;


    @Test
    @Order(1)
    public void saveContactTest() {


        Contact contact = Contact.builder()
                .email("a@g.com")
                .message("asd")
                .build();
        
        contactRepo.save(contact);

        Assertions.assertThat(contact.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getContactTest() {

        Contact contact = Contact.builder()
                .email("a@g.com")
                .message("asd")
                .build();

        contactRepo.save(contact);


        Contact contactCreated = contactRepo.findById(contact.getId()).get();
        Assertions.assertThat(contactCreated.getId()).isEqualTo(contact.getId());

    }

    @Test
    @Order(3)
    public void getListOfContactTest(){
        Contact contact = Contact.builder()
                .email("a@g.com")
                .message("asd")
                .build();

        contactRepo.save(contact);
        List<Contact> User = contactRepo.findAll();
        Assertions.assertThat(User.size()).isGreaterThan(0);
    }


    @Test
    @Order(4)
    public void updateContactTest(){

        Contact contact = Contact.builder()
                .email("a@g.com")
                .message("asd")
                .build();

        contactRepo.save(contact);

        Contact contact1  = contactRepo.findById(contact.getId()).get();

        contact1.setEmail("b@g.com");

        Contact contactUpdated  = contactRepo.save(contact);

        Assertions.assertThat(contactUpdated.getEmail()).isEqualTo("b@g.com");

    }

    @Test
    @Order(5)
    public void deleteContactTest(){

        Contact contact = Contact.builder()
                .email("a@g.com")
                .message("asd")
                .build();

        contactRepo.save(contact);

//        @Query(value = "SELECT * from")

        Contact contact1 = contactRepo.findById(contact.getId()).get();
        contactRepo.delete(contact1);

        Contact contact2 = null;
        Optional<Contact> optionalContact = contactRepo.findContactByEmail("a@g.com");
        if(optionalContact.isPresent()){
            contact2 = optionalContact.get();
        }

        Assertions.assertThat(contact2).isNull();
//        Assertions.assertThat(User1.getId()).isNull();
    }
}
