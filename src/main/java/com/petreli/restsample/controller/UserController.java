package com.petreli.restsample.controller;

import com.petreli.restsample.model.User;
import com.petreli.restsample.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserController {
    private final UserService userService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        log.info("getting all users from database");

        return userService
                .getAll();
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public User getById(@PathVariable(name = "id") Long id) {
        log.info("getting user by id '{}'", id);

        return userService
                .getById(id)
                .orElseThrow(() ->
                        new NoSuchElementException(String.format("user with id '%d' not found", id))
                );
    }
}
