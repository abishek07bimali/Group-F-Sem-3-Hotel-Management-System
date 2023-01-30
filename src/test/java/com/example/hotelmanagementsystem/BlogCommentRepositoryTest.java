package com.example.hotelmanagementsystem;

import com.example.hotelmanagementsystem.entity.Blog;
import com.example.hotelmanagementsystem.repo.BlogRepo;
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
public class BlogCommentRepositoryTest {

    @Autowired
    private BlogRepo blogRepo;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveContactTest() {

        Blog blog = Blog.builder()
                .author("rakshit")
                .topic("breaking news")
                .content("asudh asubdh")
                .phoneNum("9808888888")
                .build();

        blogRepo.save(blog);

        Assertions.assertThat(blog.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getContactTest() {

        Blog blog = Blog.builder()
                .author("rakshit")
                .topic("breaking news")
                .content("asudh asubdh")
                .phoneNum("9808888888")
                .build();

        blogRepo.save(blog);

        Blog blogCreated = blogRepo.findById(blog.getId()).get();
        Assertions.assertThat(blogCreated.getId()).isEqualTo(blog.getId());

    }

    @Test
    @Order(3)
    public void getListOfContactTest(){
        Blog blog = Blog.builder()
                .author("rakshit")
                .topic("breaking news")
                .content("asudh asubdh")
                .phoneNum("9808888888")
                .build();

        blogRepo.save(blog);
        List<Blog> User = blogRepo.findAll();
        Assertions.assertThat(User.size()).isGreaterThan(0);
    }


    @Test
    @Order(4)
    public void updateContactTest(){

        Blog blog = Blog.builder()
                .author("rakshit")
                .topic("breaking news")
                .content("asudh asubdh")
                .phoneNum("9808888888")
                .build();

        blogRepo.save(blog);

        Blog blog1  = blogRepo.findById(blog.getId()).get();

        blog1.setTopic("new topic");

        Blog blogUpdated  = blogRepo.save(blog);

        Assertions.assertThat(blogUpdated.getTopic()).isEqualTo("new topic");

    }

    @Test
    @Order(5)
    public void deleteContactTest(){

        Blog blog = Blog.builder()
                .author("rakshit")
                .topic("breaking news")
                .content("asudh asubdh")
                .phoneNum("9808888888")
                .build();

        blogRepo.save(blog);

//        @Query(value = "SELECT * from")

        Blog blog1 = blogRepo.findById(blog.getId()).get();
        blogRepo.delete(blog1);

        Blog blog2 = null;
        Optional<Blog> optionalBlog = blogRepo.findBlogByTopic("a@g.com");
        if(optionalBlog.isPresent()){
            blog2 = optionalBlog.get();
        }

        Assertions.assertThat(blog2).isNull();

    }


}
