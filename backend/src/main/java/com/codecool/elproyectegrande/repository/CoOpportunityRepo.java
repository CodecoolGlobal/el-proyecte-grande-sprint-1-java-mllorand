package com.codecool.elproyectegrande.repository;

import com.codecool.elproyectegrande.model.coopportunity.CoOpportunity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoOpportunityRepo extends JpaRepository<CoOpportunity, Long> {
}