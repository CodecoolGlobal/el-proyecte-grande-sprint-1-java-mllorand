package com.codecool.elproyectegrande.controller;

import com.codecool.elproyectegrande.model.AffinityLabel;
import com.codecool.elproyectegrande.service.AffinityLabelService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({"http://localhost:3000", "https://codecrush.postman.co"})
@RequestMapping("/affinityLabel")
public class AffinityLabelController {
    AffinityLabelService affinityLabelService;

    public AffinityLabelController(AffinityLabelService affinityLabelService) {
        this.affinityLabelService = affinityLabelService;
    }

    @GetMapping("/all")
    public Iterable<AffinityLabel> displayAllLabels() {
        return affinityLabelService.findAll();
    }
}
