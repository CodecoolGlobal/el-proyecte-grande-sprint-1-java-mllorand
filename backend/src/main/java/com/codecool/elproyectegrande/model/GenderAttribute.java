package com.codecool.elproyectegrande.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class GenderAttribute extends CooperatorAttribute<Gender> {
    public GenderAttribute(long id, Gender attributeValue, Visibility visibility) {
        super(id, attributeValue, visibility);
    }
}
