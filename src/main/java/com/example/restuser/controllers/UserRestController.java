package com.example.restuser.controllers;

import com.example.restuser.models.User;
import com.example.restuser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @GetMapping("/{id}")
    public User getUserById(@PathVariable(name = "id")Long id){
        return userService.getUserById(id);
    }
}
