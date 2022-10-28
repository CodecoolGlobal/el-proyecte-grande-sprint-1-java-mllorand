package com.codecool.elproyectegrande.repository;

import com.codecool.elproyectegrande.model.Visibility;
import com.codecool.elproyectegrande.model.coopportunity.CoOpportunity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoOpportunityRepo extends JpaRepository<CoOpportunity, Long> {
    List<CoOpportunity> findByVisibility(Visibility visibility, Pageable pageable);
}