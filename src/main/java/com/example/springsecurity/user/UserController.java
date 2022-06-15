package com.example.springsecurity.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private static final List<User> USERS = Arrays.asList(
            new User(1, "Madushan"),
            new User(2, "Dulmini"),
            new User(3, "Ruvindu"),
            new User(4, "Hameesha"),
            new User(5, "Ravindu")
    );

    @GetMapping(path = "/{userId}")
    public User getUsers(@PathVariable("userId") Integer userId) {
        return USERS.stream()
                .filter(user -> userId.equals(user.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("User does not exists"));
    }

}
