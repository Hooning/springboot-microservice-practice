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
import java.util.Optional;

@RestController
public class UserJpaResource {
    @Autowired
    private UserRepository userRepository;

    // retrieveAllUsers
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    // retrieveUser(int id)
    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable final int id) {
//        User user = userService.findOne(id);
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new UserNotFoundException("id-" + id);
        }

        // HATEOAS
        // include retrieveAllUsers
        EntityModel<User> resource = EntityModel.of(user.get());
        WebMvcLinkBuilder linkTo =
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());

        resource.add(linkTo.withRel("all-users"));


        return resource;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable final int id) {
//        Optional<User> user = userRepository.findById(id);
//        user.ifPresent(value -> userRepository.deleteById(value.getId()));
        userRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
