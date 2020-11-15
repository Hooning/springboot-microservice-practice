package com.hooning.practicespringboot.graphql;

import com.hooning.practicespringboot.posts.Post;
import com.hooning.practicespringboot.posts.PostRepository;
import com.hooning.practicespringboot.user.UserRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GraphQLDataFetchers {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public DataFetcher getPostByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            Integer postId = dataFetchingEnvironment.getArgument("postId");

            return this.postRepository.findById(postId)
                    .stream()
                    .filter(post -> post.getPostId().equals(postId))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getUserDataFetcher() {
        return dataFetchingEnvironment -> {
            Post post = dataFetchingEnvironment.getSource();
            Integer userId = post.getPostedById();
            return this.userRepository.findById(userId)
                    .stream()
                    .filter(user -> user.getId().equals(userId))
                    .findFirst()
                    .orElse(null);
        };
    }
}
