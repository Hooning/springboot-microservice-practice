package com.hooning.practicespringboot.posts;


import com.hooning.practicespringboot.user.UserDaoService;
import com.hooning.practicespringboot.user.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class PostDaoService {
//    private static final List<Post> posts = new ArrayList<>();
//    public static int postsCount = 5;
//    private static final UserDaoService userDaoService = new UserDaoService();
//
//    static {
//        posts.add(new Post(1, UUID.randomUUID().toString(), "Hello Mr.Cho", userDaoService.findOne(1), new Date()));
//        posts.add(new Post(2, UUID.randomUUID().toString(), "How was your weekend?", userDaoService.findOne(1), new Date()));
//        posts.add(new Post(3, UUID.randomUUID().toString(), "Guten Morgen", userDaoService.findOne(2), new Date()));
//        posts.add(new Post(4, UUID.randomUUID().toString(), "Alles Gute :)", userDaoService.findOne(3), new Date()));
//        posts.add(new Post(5, UUID.randomUUID().toString(), "Guten Abend", userDaoService.findOne(2), new Date()));
//    }
//
//    public List<Post> findAll(Integer userId) {
//        return posts.stream().filter(post -> post.getUserId().equals(userId)).collect(Collectors.toList());
//    }
//
//    public void save(Integer userId, Post post) {
//        if (userDaoService.findOne(userId) == null) {
//            throw new UserNotFoundException("user-" + userId + " does not exist in the system");
//        } else {
//            post.setUserId(userId);
//        }
//
//        if (post.getPostId() == null) {
//            post.setPostId(UUID.randomUUID().toString());
//        } else {
//            if (posts.stream().noneMatch((p) -> (p.getPostId().equals(post.getPostId())))) {
//                post.setPostId(UUID.randomUUID().toString());
//            } else {
//                throw new PostAlreadyExistException("The post you wrote already exist");
//            }
//        }
//        posts.add(post);
//    }
//
//    public Post findOne(Integer userId, String postId) {
//        for (Post post : posts) {
//            if (post.getUserId().equals(userId) && post.getPostId().equals(postId)) {
//                return post;
//            }
//        }
//        return null;
//    }
}
