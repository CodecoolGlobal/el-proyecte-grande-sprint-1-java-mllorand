package com.codecool.elproyectegrande.persistance;

import com.codecool.elproyectegrande.model.GenderAttribute;
import org.springframework.data.repository.CrudRepository;

public interface GenderAttributeDAO extends CrudRepository<GenderAttribute, Long> {
}
