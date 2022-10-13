package com.codecool.elproyectegrande.controller;

import com.codecool.elproyectegrande.model.*;
import com.codecool.elproyectegrande.service.CooperatorProfileService;
import org.springframework.http.MediaType;
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

    @PatchMapping("/{userId}/username")
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

    @PatchMapping("/{userId}/gender")
    public ResponseEntity<String> changeUserName(@PathVariable long userId, @RequestBody GenderAttribute updatedGender) {
        var gender = cooperatorService.getGender(userId);
        if (gender.isPresent()) {
            updatedGender.setId(gender.get().getId());
            cooperatorService.updateGender(updatedGender);
            return ResponseEntity.ok("");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{userId}/email-address")
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

    @PatchMapping("/{userId}/full-name")
    public ResponseEntity<String> changeFullName(@PathVariable long userId, @RequestBody StringAttribute updatedFullName) {
        var fullName = cooperatorService.getFullName(userId);

        if(fullName.isPresent()) {
            updatedFullName.setId(fullName.get().getId());
            cooperatorService.updateFullName(updatedFullName);
            return ResponseEntity.ok("");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{userId}/age")
    public ResponseEntity<String> changeAge(@PathVariable long userId, @RequestBody IntegerAttribute updatedAge) {
        var age = cooperatorService.getAge(userId);

        if(age.isPresent()) {
            updatedAge.setId(age.get().getId());
            try {
                cooperatorService.updateAge(updatedAge);
            } catch (IllegalArgumentException ignored) {
                return ResponseEntity.badRequest()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(String.format(
                        "{\n  \"MINIMUM_AGE\": %d,\n  \"MAXIMUM_AGE\": %d\n}",
                        CooperatorProfileService.MINIMUM_AGE,
                        CooperatorProfileService.MAXIMUM_AGE
                    ));
            }
            return ResponseEntity.ok("");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{userId}/strength")
    public ResponseEntity<String> addNewCooperatorStrength(@PathVariable long userId, @RequestBody AffinityLabel newStrength) {
        if(cooperatorService.addNewStrength(userId, newStrength)) {
            return ResponseEntity.ok("");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

