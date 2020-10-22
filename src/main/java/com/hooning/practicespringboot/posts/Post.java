package com.hooning.practicespringboot.posts;

import com.hooning.practicespringboot.user.User;

import java.util.Date;

public class Post {
    private String postId;
    private String content;
    private User postedBy;
    private Date postedOn;

    public Post(String postId, String content, User postedBy, Date postedOn) {
        this.postId = postId;
        this.content = content;
        this.postedBy = postedBy;
        this.postedOn = postedOn;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(User postedBy) {
        this.postedBy = postedBy;
    }

    public Date getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }
}