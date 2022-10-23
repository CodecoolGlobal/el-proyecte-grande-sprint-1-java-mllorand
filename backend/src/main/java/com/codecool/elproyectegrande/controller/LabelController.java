package com.codecool.elproyectegrande.controller;

import com.codecool.elproyectegrande.model.label.InterestLabel;
import com.codecool.elproyectegrande.model.label.SkillLabel;
import com.codecool.elproyectegrande.model.label.TechLabel;
import com.codecool.elproyectegrande.service.LabelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin({"http://localhost:3000", "https://codecrush.postman.co"})
@RequestMapping("/label")
@RequiredArgsConstructor
public class LabelController {
    private final LabelService labelService;

    @GetMapping("/labels")
    public Iterable<TechLabel> getAllTechLabels() {
        return labelService.findAll();
    }
}
