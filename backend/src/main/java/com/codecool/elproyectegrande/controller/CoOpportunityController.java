package com.codecool.elproyectegrande.controller;

import com.codecool.elproyectegrande.model.coopportunity.CoOpportunity;
import com.codecool.elproyectegrande.service.CoOpportunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin({"http://localhost:3000", "https://codecrush.postman.co"})
@RequestMapping("/coopportunity")
@RequiredArgsConstructor
public class CoOpportunityController {
    private final CoOpportunityService coOpportinityService;

    @GetMapping("/coopportunities")
    public Iterable<CoOpportunity> getAllCooperators() {
        return coOpportinityService.findAllVisibleToCooperator(0);
    }

    @GetMapping("/coopportunities/{pageNumber}")
    public Iterable<CoOpportunity> getAllCooperators(@PathVariable int pageNumber) {
        return coOpportinityService.findAllVisibleToCooperator(pageNumber - 1);
    }
}
