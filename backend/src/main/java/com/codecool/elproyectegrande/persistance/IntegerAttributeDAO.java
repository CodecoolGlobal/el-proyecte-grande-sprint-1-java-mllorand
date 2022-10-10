package com.codecool.elproyectegrande.persistance;

import com.codecool.elproyectegrande.model.IntegerAttribute;
import org.springframework.data.repository.CrudRepository;

public interface IntegerAttributeDAO extends CrudRepository<IntegerAttribute, Long> {
}
