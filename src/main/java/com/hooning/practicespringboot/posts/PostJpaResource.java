package com.hooning.practicespringboot.posts;

import com.hooning.practicespringboot.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class PostJpaResource {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    // retrieveAllPosts
    @GetMapping("/jpa/users/{userId}/posts")
    public List<Post> retrieveAllPosts(@PathVariable Integer userId) {
        Optional<List<Post>> posts = postRepository.findByUserId(userId);
        return posts.orElse(null);
    }

    // retrieveSinglePost
    @GetMapping("/jpa/users/{userId}/posts/{postId}")
    public Post retrieveSinglePost(@PathVariable Integer userId, @PathVariable Integer postId) {
        Optional<Post> post = postRepository.findByUserIdAndPostId(userId, postId);

        if (post.isEmpty()) {
            throw new PostNotFoundException("userId = [" + userId + "] and postId = [" + postId + "] does not exist");
        }
        return post.get();
    }

    // create new post
    @PostMapping("/jpa/users/{userId}/posts")
    public ResponseEntity<Post> createPost(@PathVariable Integer userId, @RequestBody Post post) {
        post.setUser(userRepository.findById(userId).orElse(null));
        postRepository.save(post);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{postId}")
                .buildAndExpand(post.getPostId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
