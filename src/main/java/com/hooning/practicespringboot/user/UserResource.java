package com.hooning.practicespringboot.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    @Autowired
    private UserDaoService userService;

    // retrieveAllUsers
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userService.findAll();
    }

    // retrieveUser(int id)
    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable final int id) {
        User user = userService.findOne(id);

        if (user == null) {
            throw new UserNotFoundException("id-" + id);
        }

        // HATEOAS
        // include retrieveAllUsers
        EntityModel<User> resource = EntityModel.of(user);
        WebMvcLinkBuilder linkTo =
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());

        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        userService.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable final int id) {
        User user = userService.findOne(id);

        if (user == null) {
            throw new UserNotFoundException("id-" + id);
        }

        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
