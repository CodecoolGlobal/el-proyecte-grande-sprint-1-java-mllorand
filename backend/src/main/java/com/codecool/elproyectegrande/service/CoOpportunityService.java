package com.codecool.elproyectegrande.service;

import com.codecool.elproyectegrande.model.Visibility;
import com.codecool.elproyectegrande.model.coopportunity.CoOpportunity;
import com.codecool.elproyectegrande.repository.CoOpportunityRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CoOpportunityService {
    private final CoOpportunityRepo coOpportunityRepo;

    public Iterable<CoOpportunity> findAllVisibleToCooperator(int pageNumber) {
        Pageable paging = PageRequest.of(pageNumber, 10);
        return coOpportunityRepo.findByVisibility(Visibility.PUBLIC, paging);
    }
}
