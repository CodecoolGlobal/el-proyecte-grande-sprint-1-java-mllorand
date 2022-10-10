package com.codecool.elproyectegrande.persistance;

import com.codecool.elproyectegrande.model.Cooperator;
import org.springframework.data.repository.CrudRepository;

public interface CooperatorDAO extends CrudRepository<Cooperator, Long> {
    Cooperator findById(long id);
}
