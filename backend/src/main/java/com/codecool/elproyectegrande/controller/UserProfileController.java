package com.codecool.elproyectegrande.controller;

import com.codecool.elproyectegrande.model.Cooperator;
import com.codecool.elproyectegrande.model.StringAttribute;
import com.codecool.elproyectegrande.service.CooperatorProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin({"http://localhost:3000", "https://codecrush.postman.co"})
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

    @PutMapping("/{userId}/username")
    public ResponseEntity<String> changeUserName(@PathVariable long userId, @RequestBody StringAttribute updatedUserName) {
        var userName = cooperatorService.getUserName(userId);

        if (userName.isPresent()) {
            updatedUserName.setId(userName.get().getId());
            cooperatorService.updateUserName(updatedUserName);
            return ResponseEntity.ok("");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{userId}/email-address")
    public ResponseEntity<String> changeEmailAddress(@PathVariable long userId, @RequestBody StringAttribute updatedEmailAddress) {
        var emailAddress = cooperatorService.getEmailAddress(userId);

        if(emailAddress.isPresent()) {
            updatedEmailAddress.setId(emailAddress.get().getId());
            cooperatorService.updateEmailAddress(updatedEmailAddress);
            return ResponseEntity.ok("");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

