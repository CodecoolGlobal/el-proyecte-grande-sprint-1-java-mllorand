package com.codecool.elproyectegrande.service;

import com.codecool.elproyectegrande.model.Visibility;
import com.codecool.elproyectegrande.model.coopportunity.CoOpportunity;
import com.codecool.elproyectegrande.model.coopportunity.JoinPolicy;
import com.codecool.elproyectegrande.model.label.InterestLabel;
import com.codecool.elproyectegrande.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CoOpportunityService {
    private static final int PAGE_SIZE = 10;
    private static final Visibility DEFAULT_VISIBILITY = Visibility.PUBLIC;
    private static final JoinPolicy DEFAULT_JOIN_POLICY = JoinPolicy.OPEN;

    private final CoOpportunityRepo coOpportunityRepo;
    private final InterestLabelRepo interestLabelRepo;
    private final TechLabelRepo techLabelRepo;
    private final TagRepo tagRepo;
    private final MissionRepo missionRepo;
    private final CooperatorService cooperatorService;

    public Iterable<CoOpportunity> findAllVisible(int pageNumber) {
        log.info("Retrieving page {} coopportunity with a page size {}", pageNumber, PAGE_SIZE);
        Pageable paging = PageRequest.of(pageNumber, PAGE_SIZE);
        List<CoOpportunity> coOpportunityList = coOpportunityRepo.findByVisibility(Visibility.PUBLIC, paging);
        log.debug(coOpportunityList.toString());
        return coOpportunityList;
    }

    public CoOpportunity saveCoOpportunity(CoOpportunity coOpportunity, String userName) {
        //TODO: split method up
        //TODO: create custom exceptions
        log.info("Checking, then saving new CoOpportunity");

        log.debug("Checking name");
        if (coOpportunity.getName() == null || coOpportunity.getName().isBlank()) {
            log.warn("name is invalid: {}", coOpportunity.getName());
            throw new IllegalArgumentException();
        }

        log.debug("Checking interest labels");
        if (coOpportunity.getInterestLabels() == null || coOpportunity.getInterestLabels().size() < 1) {
            log.warn("interest label invalid: {}", coOpportunity.getInterestLabels());
            throw new IllegalArgumentException();
        }
        findOrCreateInterestLabels(coOpportunity);

        log.debug("checking missions");
        if (coOpportunity.getMission() == null) {
            log.warn("mission is invalid: {}", coOpportunity.getMission());
            throw new IllegalArgumentException();
        }
        coOpportunity.setMission(missionRepo.save(coOpportunity.getMission()));


        log.debug("checking visibility");
        if (coOpportunity.getVisibility() == null) {
            log.debug("no visibility found, reverting to default: {}", DEFAULT_VISIBILITY);
            coOpportunity.setVisibility(DEFAULT_VISIBILITY);
        }

        log.debug("checking join policy");
        if (coOpportunity.getJoinPolicy() == null) {
            log.debug("no join policy found, reverting to default: {}", DEFAULT_JOIN_POLICY);
            coOpportunity.setJoinPolicy(DEFAULT_JOIN_POLICY);
        }

        coOpportunity.setCooperators(List.of(cooperatorService.findByName(userName)));

        return coOpportunityRepo.save(coOpportunity);
    }

    private void findOrCreateInterestLabels(CoOpportunity coOpportunity) {
        coOpportunity.setInterestLabels(coOpportunity.getInterestLabels().stream()
            .map(label ->
                interestLabelRepo.findOne(Example.of(label))
                    .orElse(createInterestLabel(label))
            )
            .collect(Collectors.toList())
        );
    }

    private InterestLabel createInterestLabel(InterestLabel interestLabel) {
        interestLabel.setLabel(techLabelRepo.findOne(Example.of(interestLabel.getLabel())).orElseThrow());

        createOrFindTags(interestLabel);

        return interestLabelRepo.save(interestLabel);
    }

    private void createOrFindTags(InterestLabel interestLabel) {
        interestLabel.setTags(interestLabel.getTags().stream()
            .map(tag ->
                tagRepo.findOne(Example.of(tag))
                    .orElse(tagRepo.save(tag))
            )
            .collect(Collectors.toList())
        );
    }
}
