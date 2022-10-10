package com.codecool.elproyectegrande.controller;

import com.codecool.elproyectegrande.model.Cooperator;
import com.codecool.elproyectegrande.persistance.CooperatorDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class UserProfileController {
    private static final int DEFAULT_USER_ID = 1;

    private final CooperatorDAO cooperatorDAO;

    public UserProfileController(CooperatorDAO cooperatorDAO) {
        this.cooperatorDAO = cooperatorDAO;
    }

    @GetMapping("/{userId}")
    public Cooperator displayUserProfile(@PathVariable long userId) {
        return cooperatorDAO.findById(userId);
    }

    @GetMapping("")
    public Cooperator displayDefaultUserProfile() {
        return cooperatorDAO.findById(DEFAULT_USER_ID);
    }
}
