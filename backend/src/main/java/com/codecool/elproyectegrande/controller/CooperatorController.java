package com.codecool.elproyectegrande.controller;

import com.codecool.elproyectegrande.model.cooperator.Cooperator;
import com.codecool.elproyectegrande.model.cooperator.attribute.GenderAttribute;
import com.codecool.elproyectegrande.model.cooperator.attribute.AgeAttribute;
import com.codecool.elproyectegrande.model.cooperator.attribute.StringAttribute;
import com.codecool.elproyectegrande.model.label.InterestLabel;
import com.codecool.elproyectegrande.model.label.SkillLabel;
import com.codecool.elproyectegrande.model.label.TechLabel;
import com.codecool.elproyectegrande.service.CooperatorService;
import com.codecool.elproyectegrande.service.LabelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin({"http://localhost:3000", "https://codecrush.postman.co"})
@RequestMapping("/cooperator")
@RequiredArgsConstructor
public class CooperatorController {
    private static final Long DEFAULT_USER_ID = 1L;
    private final CooperatorService cooperatorService;
    private final LabelService labelService;

    @GetMapping("/cooperators")
    public Iterable<Cooperator> getAllCooperators() {
        return cooperatorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cooperator> getUserProfile(@PathVariable Long id) {
        return ResponseEntity.ok().body(cooperatorService.findById(id));
    }

    @GetMapping("")
    public ResponseEntity<Cooperator> getDefaultUserProfile() {
        return ResponseEntity.ok().body(cooperatorService.findById(DEFAULT_USER_ID));
    }

    @PostMapping("/cooperator/save")
    public ResponseEntity<Cooperator> saveUser(@RequestBody Cooperator appUser) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/cooperator/save").toUriString());
        return ResponseEntity.created(uri).body(cooperatorService.saveUser(appUser));
    }

    @PatchMapping("/name")
    public ResponseEntity<Cooperator> changeName( @RequestBody String updatedName, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.updateName(cooperator.getId(), updatedName));
    }

    @PatchMapping("/gender")
    public ResponseEntity<Cooperator> changeGender(@RequestBody GenderAttribute updatedGender, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.updateGender(cooperator.getId(), updatedGender));
    }

    @PatchMapping("/emailAddress")
    public ResponseEntity<Cooperator> changeEmailAddress(@RequestBody StringAttribute updatedEmailAddress, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.updateEmailAddress(cooperator.getId(), updatedEmailAddress));
    }

    @PatchMapping("/age")
    public ResponseEntity<Cooperator> changeAge(@RequestBody AgeAttribute updatedAge, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.updateAge(cooperator.getId(), updatedAge));
    }


    @PatchMapping("/fullName")
    public ResponseEntity<Cooperator> changeFullName(@RequestBody StringAttribute updatedFullName, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.updateFullName(cooperator.getId(), updatedFullName));
    }

    @PostMapping("/strengths")
    public ResponseEntity<Cooperator> addNewStrength(@RequestBody TechLabel newStrength, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.addNewStrength(cooperator.getId(), newStrength));
    }

    @PostMapping("/learnFromScratch")
    public ResponseEntity<Cooperator> addNewLearnFromScratch(@RequestBody TechLabel newLearnFromScratch, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.addNewLearnFromScratch(cooperator.getId(), newLearnFromScratch));
    }

    @PostMapping("/improveIn")
    public ResponseEntity<Cooperator> addNewImproveIn(@RequestBody TechLabel newImproveIn, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.addNewImproveIn(cooperator.getId(), newImproveIn));
    }

    @PostMapping("/skill")
    public ResponseEntity<Cooperator> addNewSkill(@RequestBody SkillLabel newSkill, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.addNewSkill(cooperator.getId(), newSkill));
    }

    @PostMapping("/interested")
    public ResponseEntity<Cooperator> addNewInterest(@RequestBody InterestLabel newInterest, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.addNewInterest(cooperator.getId(), newInterest));
    }

    @PatchMapping("/skill")
    public ResponseEntity<SkillLabel> changeSkill(@RequestBody SkillLabel updatedSkill, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(labelService.updateSkill(cooperator.getId(), updatedSkill));
    }

    @PatchMapping("/interested")
    public ResponseEntity<InterestLabel> changeInterest(@RequestBody InterestLabel updatedInterest, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(labelService.updateInterest(cooperator.getId(), updatedInterest));
    }
}

