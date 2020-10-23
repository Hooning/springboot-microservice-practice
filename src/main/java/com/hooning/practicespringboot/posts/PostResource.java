package com.hooning.practicespringboot.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PostResource {
    @Autowired
    private PostDaoService postService;

    // retrieveAllPosts
    @GetMapping("/users/{userId}/posts")
    public List<Post> retrieveAllPosts(@PathVariable Integer userId) {
        return postService.findAll(userId);
    }

    // retrieveSinglePost
    @GetMapping("/users/{userId}/posts/{postId}")
    public Post retrieveSinglePost(@PathVariable Integer userId, @PathVariable String postId) {
        Post post = postService.findOne(userId, postId);

        if (post == null) {
            throw new PostNotFoundException("userId = [" + userId + "] and postId = [" + postId + "] does not exist");
        }
        return post;
    }

    // create new post
    @PostMapping("/users/{userId}/posts")
    public ResponseEntity<Post> createPost(@PathVariable Integer userId, @RequestBody Post post) {
        postService.save(userId, post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{postId}")
                .buildAndExpand(post.getPostId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
