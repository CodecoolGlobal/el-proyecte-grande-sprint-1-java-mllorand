package com.codecool.elproyectegrande.service;

import com.codecool.elproyectegrande.model.cooperator.Cooperator;
import com.codecool.elproyectegrande.model.customexception.InterestLabelNotFoundException;
import com.codecool.elproyectegrande.model.customexception.SkillLabelNotFoundException;
import com.codecool.elproyectegrande.model.label.InterestLabel;
import com.codecool.elproyectegrande.model.label.SkillLabel;
import com.codecool.elproyectegrande.model.label.Tag;
import com.codecool.elproyectegrande.model.label.TechLabel;
import com.codecool.elproyectegrande.repository.InterestLabelRepo;
import com.codecool.elproyectegrande.repository.SkillLabelRepo;
import com.codecool.elproyectegrande.repository.TagRepo;
import com.codecool.elproyectegrande.repository.TechLabelRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LabelService {
    private final TechLabelRepo techLabelRepo;
    private final SkillLabelRepo skillLabelRepo;
    private final InterestLabelRepo interestLabelRepo;
    //private final CooperatorService cooperatorService;
    private final TagRepo tagRepo;

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


    public SkillLabel updateSkill(Cooperator cooperator, SkillLabel updatedSkill) {
        List<Long> coopSkillIds = cooperator.getSkills().stream().map(SkillLabel::getId).toList();
        for (var id : coopSkillIds) {
            if (Objects.equals(id, updatedSkill.getId())) {
                var skillLabel = skillLabelRepo.findById(updatedSkill.getId()).get();
                skillLabel.setSkillQuantity(updatedSkill.getSkillQuantity());
                skillLabel.setSkillUnit(updatedSkill.getSkillUnit());
                return skillLabel;
            }
        }
        log.error("Skill {} not in cooperator", updatedSkill);
        throw new RuntimeException("skill not in cooperator");
    }

    public InterestLabel updateInterest(Cooperator cooperator, InterestLabel updatedInterest) {
        List<Long> coopInterestIds = cooperator.getInterests().stream().map(InterestLabel::getId).toList();
        for (var id : coopInterestIds) {
            if (Objects.equals(id, updatedInterest.getId())) {
                var interestLabel = interestLabelRepo.findById(updatedInterest.getId()).get();
                interestLabel.setInterestPriority(updatedInterest.getInterestPriority());
                interestLabel.setTags(updatedInterest.getTags());
                return interestLabel;
            }
        }
        log.error("interest {} not in cooperator", updatedInterest);
        throw new RuntimeException("interest not in cooperator");
    }

    public SkillLabel createSkillLabel(SkillLabel skillLabel) {
        skillLabel.setLabel(techLabelRepo.findOne(Example.of(skillLabel.getLabel())).orElseThrow());
        return skillLabelRepo.save(skillLabel);
    }

    public InterestLabel createInterestLabel(InterestLabel interestLabel) {
        interestLabel.setLabel(techLabelRepo.findOne(Example.of(interestLabel.getLabel())).orElseThrow());

        interestLabel.setTags(interestLabel.getTags().stream()
            .map(this::createOrFindTag)
            .collect(Collectors.toList())
        );

        return interestLabelRepo.save(interestLabel);
    }

    private Tag createOrFindTag(Tag tag) {
        return tagRepo.findOne(Example.of(tag))
            .orElse(tagRepo.save(tag));
    }
}
