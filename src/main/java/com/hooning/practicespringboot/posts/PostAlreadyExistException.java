package com.hooning.practicespringboot.posts;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PostAlreadyExistException extends RuntimeException {
    public PostAlreadyExistException(String message) {
        super(message);
    }
}
