package com.example.springsecurity.user;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/users")
public class UserManagementController {

    private static final List<User> USERS = Arrays.asList(
            new User(1, "Madushan"),
            new User(2, "Dulmini"),
            new User(3, "Ruvindu"),
            new User(4, "Hameesha"),
            new User(5, "Ravindu")
    );

    @GetMapping
    public static List<User> getAllUSERS() {
        return USERS;
    }

    @PostMapping
    public void registerNewUser(@RequestBody User user) {
        System.out.println(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId) {
        System.out.println(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Integer userId, @RequestBody User user) {
        System.out.println(String.format("%s %s", user, user));
    }
}
