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
    public ResponseEntity<Cooperator> changeName(@RequestBody String updatedName, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.updateName(cooperator, updatedName));
    }

    @PatchMapping("/gender")
    public ResponseEntity<Cooperator> changeGender(@RequestBody GenderAttribute updatedGender, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.updateGender(cooperator, updatedGender));
    }

    @PatchMapping("/emailAddress")
    public ResponseEntity<Cooperator> changeEmailAddress(@RequestBody StringAttribute updatedEmailAddress, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.updateEmailAddress(cooperator, updatedEmailAddress));
    }

    @PatchMapping("/age")
    public ResponseEntity<Cooperator> changeAge(@RequestBody AgeAttribute updatedAge, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.updateAge(cooperator, updatedAge));
    }


    @PatchMapping("/fullName")
    public ResponseEntity<Cooperator> changeFullName(@RequestBody StringAttribute updatedFullName, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.updateFullName(cooperator, updatedFullName));
    }

    @PatchMapping("/skill")
    public ResponseEntity<SkillLabel> changeSkill(@RequestBody SkillLabel updatedSkill, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(labelService.updateSkill(cooperator, updatedSkill));
    }

    @PatchMapping("/interest")
    public ResponseEntity<InterestLabel> changeInterest(@RequestBody InterestLabel updatedInterest, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(labelService.updateInterest(cooperator, updatedInterest));
    }

    @PostMapping("/strength")
    public ResponseEntity<Cooperator> addNewStrength(@RequestBody TechLabel newStrength, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.addNewStrength(cooperator, newStrength));
    }

    @PostMapping("/learnFromScratch")
    public ResponseEntity<Cooperator> addNewLearnFromScratch(@RequestBody TechLabel newLearnFromScratch, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.addNewLearnFromScratch(cooperator, newLearnFromScratch));
    }

    @PostMapping("/improveIn")
    public ResponseEntity<Cooperator> addNewImproveIn(@RequestBody TechLabel newImproveIn, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.addNewImproveIn(cooperator, newImproveIn));
    }

    @PostMapping("/skill")
    public ResponseEntity<Cooperator> addNewSkill(@RequestBody SkillLabel newSkill, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.addNewSkill(cooperator, newSkill));
    }

    @PostMapping("/interest")
    public ResponseEntity<Cooperator> addNewInterest(@RequestBody InterestLabel newInterest, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.addNewInterest(cooperator, newInterest));
    }

    @DeleteMapping("/strength")
    public ResponseEntity<Cooperator> deleteStrength(@RequestBody TechLabel strength, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.deleteStrength(cooperator, strength));
    }

    @DeleteMapping("/learnFromScratch")
    public ResponseEntity<Cooperator> deleteLearnFromScratch(@RequestBody TechLabel learnFromScratch, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.deleteLearnFromScratch(cooperator, learnFromScratch));
    }

    @DeleteMapping("/improveIn")
    public ResponseEntity<Cooperator> deleteImproveIn(@RequestBody TechLabel improveIn, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.deleteImproveIn(cooperator, improveIn));
    }

    @DeleteMapping("/skill")
    public ResponseEntity<Cooperator> deleteSkill(@RequestBody SkillLabel skill, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.deleteSkill(cooperator, skill));
    }

    @DeleteMapping("/interest")
    public ResponseEntity<Cooperator> deleteInterest(@RequestBody InterestLabel interest, @AuthenticationPrincipal User user) {
        Cooperator cooperator = cooperatorService.findByName(user.getUsername());
        return ResponseEntity.ok().body(cooperatorService.deleteInterest(cooperator, interest));
    }
}

