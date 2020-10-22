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
    @GetMapping("/posts")
    public List<Post> retrieveAllPosts() {
        return postService.findAll();
    }

    // retrieveSinglePost
    @GetMapping("/posts/{postId}")
    public Post retrieveSinglePost(@PathVariable String postId) {
        Post post = postService.findOne(postId);

        if (post == null) {
            throw new PostNotFoundException("postId = [" + postId + "] does not exist");
        }
        return post;
    }

    // create new post
    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        postService.save(post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{postId}")
                .buildAndExpand(post.getPostId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
