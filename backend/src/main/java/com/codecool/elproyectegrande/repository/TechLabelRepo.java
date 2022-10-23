package com.codecool.elproyectegrande.repository;

import com.codecool.elproyectegrande.model.label.TechLabel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechLabelRepo extends JpaRepository<TechLabel, Long> {
}
