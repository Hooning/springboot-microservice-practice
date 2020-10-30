package com.hooning.practicespringboot.posts;

import com.hooning.practicespringboot.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Integer postId;
    private String content;

    @ManyToOne(fetch=FetchType.LAZY)
    private User user;
    private Integer postedById;

    private Date postedOn;

    public Post(Integer postId, String content, Integer postedById, Date postedOn) {
        this.postId = postId;
        this.content = content;
        this.postedById = postedById;
        this.postedOn = postedOn;
    }

    public Post() {}

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPostedById() {
        return postedById;
    }

    public void setPostedById(Integer postedById) {
        this.postedById = postedById;
    }

    public Date getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }
}
