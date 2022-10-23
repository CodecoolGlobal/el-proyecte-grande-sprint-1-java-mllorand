package com.codecool.elproyectegrande.repository;

import com.codecool.elproyectegrande.model.cooperator.Cooperator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CooperatorRepo extends JpaRepository<Cooperator, Long> {
    Cooperator findByName(String name);
}
