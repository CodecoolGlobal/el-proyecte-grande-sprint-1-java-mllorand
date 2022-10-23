package com.codecool.elproyectegrande.repository;

import com.codecool.elproyectegrande.model.label.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepo extends JpaRepository<Tag, Long> {
}