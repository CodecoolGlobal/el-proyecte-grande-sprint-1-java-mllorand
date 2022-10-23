package com.codecool.elproyectegrande.repository;

import com.codecool.elproyectegrande.model.resource.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepo extends JpaRepository<Resource, Long> {
}