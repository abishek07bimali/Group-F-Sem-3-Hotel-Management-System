package com.example.hotelmanagementsystem.UserPojo;

import com.example.hotelmanagementsystem.entity.Blog_Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentPojo {
    private Integer id;
    private  String fullname;
    private  String comment;

    private  String email;
//    private int blog_id;

    public CommentPojo(Blog_Comment blogComment) {
        this.id=blogComment.getId();
        this.fullname=blogComment.getFullname();
        this.comment=blogComment.getComment();
        this.email=blogComment.getEmail();;
//        this.blog_id=blogComment.getBlogId().getId();
    }
}
