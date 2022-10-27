package com.codecool.elproyectegrande.controller;

import com.codecool.elproyectegrande.model.coopportunity.CoOpportunity;
import com.codecool.elproyectegrande.service.CoOpportunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin({"http://localhost:3000", "https://codecrush.postman.co"})
@RequestMapping("/api/coopportunity")
@RequiredArgsConstructor
public class CoOpportunityController {
    private final CoOpportunityService coOpportinityService;

    @GetMapping("/coopportunities")
    public Iterable<CoOpportunity> getAllCooperators() {
        return coOpportinityService.findAllVisible(0);
    }

    @GetMapping("/coopportunities/{pageNumber}")
    public Iterable<CoOpportunity> getAllCooperators(@PathVariable int pageNumber) {
        return coOpportinityService.findAllVisible(pageNumber - 1);
    }

    @PostMapping("/save")
    public ResponseEntity<CoOpportunity> createNewCoOpportunity(@RequestBody CoOpportunity coOpportunity) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/cooperator/save").toUriString());
        return ResponseEntity.created(uri).body(coOpportinityService.saveCoOpportunity(coOpportunity));
    }
}
