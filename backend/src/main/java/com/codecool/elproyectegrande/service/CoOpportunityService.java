package com.codecool.elproyectegrande.service;

import com.codecool.elproyectegrande.model.Visibility;
import com.codecool.elproyectegrande.model.cooperator.Cooperator;
import com.codecool.elproyectegrande.model.coopportunity.CoOpportunity;
import com.codecool.elproyectegrande.model.coopportunity.JoinPolicy;
import com.codecool.elproyectegrande.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private final MissionRepo missionRepo;

    private final CooperatorService cooperatorService;
    private final LabelService labelService;

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

        coOpportunity.setInterestLabels(coOpportunity.getInterestLabels().stream()
            .map(labelService::findOrCreateInterestLabel)
            .collect(Collectors.toList())
        );

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

        Cooperator firstMember = cooperatorService.findByName(userName);
        coOpportunity.setOwner(firstMember);
        coOpportunity.setCooperators(List.of(firstMember));

        return coOpportunityRepo.save(coOpportunity);
    }
}
