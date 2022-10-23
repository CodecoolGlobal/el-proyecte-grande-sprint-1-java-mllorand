package com.codecool.elproyectegrande.repository;

import com.codecool.elproyectegrande.model.cooperator.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
