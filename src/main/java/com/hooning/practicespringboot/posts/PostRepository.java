package com.hooning.practicespringboot.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    Optional<List<Post>> findByUserId(Integer userId);

    Optional<Post> findByUserIdAndPostId(Integer user_id, Integer postId);
}
