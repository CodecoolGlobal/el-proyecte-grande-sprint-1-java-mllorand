package com.codecool.elproyectegrande.controller;

import com.codecool.elproyectegrande.model.Cooperator;
import com.codecool.elproyectegrande.persistance.CooperatorDAO;
import com.codecool.elproyectegrande.service.CooperatorProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class UserProfileController {
    private static final long DEFAULT_USER_ID = 1;

    private final CooperatorProfileService cooperatorService;

    public UserProfileController(CooperatorProfileService cooperatorService) {
        this.cooperatorService = cooperatorService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Cooperator> displayUserProfile(@PathVariable long userId) {
        return cooperatorService.findById(userId)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("")
    public ResponseEntity<Cooperator> displayDefaultUserProfile() {
        return cooperatorService.findById(DEFAULT_USER_ID)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
