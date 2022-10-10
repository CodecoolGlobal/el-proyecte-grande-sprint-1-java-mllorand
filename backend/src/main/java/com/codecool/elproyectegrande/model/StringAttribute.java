package com.codecool.elproyectegrande.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class StringAttribute extends CooperatorAttribute<String> {
    public StringAttribute(long id, String attributeValue, Visibility visibility) {
        super(id, attributeValue, visibility);
    }
}
