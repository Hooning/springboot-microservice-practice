package com.hooning.practicespringboot.posts;


import com.hooning.practicespringboot.user.UserDaoService;
import com.hooning.practicespringboot.user.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class PostDaoService {
    private static final List<Post> posts = new ArrayList<>();
    public static int postsCount = 5;
    private static final UserDaoService userDaoService = new UserDaoService();

    static {
        posts.add(new Post(UUID.randomUUID().toString(), "Hello Mr.Cho", userDaoService.findOne(1), new Date()));
        posts.add(new Post(UUID.randomUUID().toString(), "How was your weekend?", userDaoService.findOne(1), new Date()));
        posts.add(new Post(UUID.randomUUID().toString(), "Guten Morgen", userDaoService.findOne(2), new Date()));
        posts.add(new Post(UUID.randomUUID().toString(), "Alles Gute :)", userDaoService.findOne(3), new Date()));
        posts.add(new Post(UUID.randomUUID().toString(), "Guten Abend", userDaoService.findOne(2), new Date()));
    }

    public List<Post> findAll() { return posts; }

    public void save(Post post) {
        if (userDaoService.findOne(post.getPostedBy().getId()) == null) {
            throw new UserNotFoundException("user-" + post.getPostedBy().getId() + " does not exist in the system");
        }

        if (post.getPostId() == null) {
            post.setPostId(UUID.randomUUID().toString());
        } else {
            if (posts.stream().noneMatch((p) -> (p.getPostId().equals(post.getPostId())))) {
                post.setPostId(UUID.randomUUID().toString());
            } else {
                throw new PostAlreadyExistException("The post you wrote already exist");
            }
        }
        posts.add(post);
    }

    public Post findOne(String postId) {
        for (Post post : posts) {
            if (post.getPostId().equals(postId)) {
                return post;
            }
        }
        return null;
    }
}
