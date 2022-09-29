package com.codecool.elproyectegrande.controller;

import com.codecool.elproyectegrande.model.Cooperator;
import com.codecool.elproyectegrande.persistance.UserDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class UserProfileController {
    private final UserDao userDao;

    public UserProfileController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/{userId}")
    public Cooperator displayUserProfile(@PathVariable long userId) {
        return userDao.findById(userId);
    }
}
