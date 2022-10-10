package com.codecool.elproyectegrande.persistance;

import com.codecool.elproyectegrande.model.StringAttribute;
import org.springframework.data.repository.CrudRepository;

public interface StringAttributeDAO extends CrudRepository<StringAttribute, Long> {
}
