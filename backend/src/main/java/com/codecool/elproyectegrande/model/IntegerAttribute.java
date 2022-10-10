package com.codecool.elproyectegrande.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class IntegerAttribute extends CooperatorAttribute<Integer> {
    public IntegerAttribute(long id, Integer attributeValue, Visibility visibility) {
        super(id, attributeValue, visibility);
    }
}
