package com.codecool.elproyectegrande.service;

import com.codecool.elproyectegrande.model.customexception.InterestLabelNotFoundException;
import com.codecool.elproyectegrande.model.customexception.SkillLabelNotFoundException;
import com.codecool.elproyectegrande.model.label.InterestLabel;
import com.codecool.elproyectegrande.model.label.SkillLabel;
import com.codecool.elproyectegrande.model.label.TechLabel;
import com.codecool.elproyectegrande.repository.InterestLabelRepo;
import com.codecool.elproyectegrande.repository.SkillLabelRepo;
import com.codecool.elproyectegrande.repository.TechLabelRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LabelService {
    private final TechLabelRepo techLabelRepo;
    private final SkillLabelRepo skillLabelRepo;
    private final InterestLabelRepo interestLabelRepo;
    private final CooperatorService cooperatorService;

    public SkillLabel getSkill(Long id) {
        Optional<SkillLabel> skillLabel = skillLabelRepo.findById(id);
        if (skillLabel.isPresent()) return skillLabel.get();
        else throw new SkillLabelNotFoundException();
    }

    public InterestLabel getInterest(Long id) {
        Optional<InterestLabel> interestLabel = interestLabelRepo.findById(id);
        if (interestLabel.isPresent()) return interestLabel.get();
        else throw new InterestLabelNotFoundException();
    }

    public Iterable<TechLabel> findAll() {
        return techLabelRepo.findAll();
    }


    public SkillLabel updateSkill(Long cooperatorId, SkillLabel updatedSkill) {
        var cooperator = cooperatorService.findById(cooperatorId);
        List<Long> coopSkillIds = cooperator.getSkills().stream().map(SkillLabel::getId).toList();
        for (var id : coopSkillIds) {
            if (Objects.equals(id, updatedSkill.getId())) {
                var skillLabel = skillLabelRepo.findById(updatedSkill.getId()).get();
                skillLabel.setSkillQuantity(updatedSkill.getSkillQuantity());
                skillLabel.setSkillUnit(updatedSkill.getSkillUnit());
                return skillLabel;
            }
        }
        {
           log.error("Skill {} not in cooperator", updatedSkill);
            throw new RuntimeException("skill not in cooperator");
        }
    }

    public InterestLabel updateInterest(Long cooperatorId, InterestLabel updatedInterest) {
        var cooperator = cooperatorService.findById(cooperatorId);
        List<Long> coopInterestIds = cooperator.getInterests().stream().map(InterestLabel::getId).toList();
        for (var id : coopInterestIds) {
            if (Objects.equals(id, updatedInterest.getId())) {
                var interestLabel = interestLabelRepo.findById(updatedInterest.getId()).get();
                interestLabel.setInterestPriority(updatedInterest.getInterestPriority());
                interestLabel.setTags(updatedInterest.getTags());
                return interestLabel;
            }
        }
        {
            log.error("interest {} not in cooperator", updatedInterest);
            throw new RuntimeException("interest not in cooperator");
        }
    }
}
