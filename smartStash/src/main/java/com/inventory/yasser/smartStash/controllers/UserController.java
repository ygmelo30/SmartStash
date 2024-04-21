package com.inventory.yasser.smartStash.controllers;

import com.inventory.yasser.smartStash.models.User;
import com.inventory.yasser.smartStash.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public List<User> getUsers () {
        return userService.getUsers();
    }

    @PostMapping(value = "/saveUser")
    public String register(@RequestBody User user) {
        userService.saveUser(user);
        return "Saved user...";
    }
    @DeleteMapping(value = "/users/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return "Deleted user...";
    }

    @PutMapping(value = "/users/{userId}")
    public String updateUser(@PathVariable Long userId, @RequestBody User user) {
        user.setId(userId);
        userService.updateUser(user);
        return "Updated user...";
    }

}
