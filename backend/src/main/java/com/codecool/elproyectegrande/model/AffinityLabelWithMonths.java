package com.codecool.elproyectegrande.model;

import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;

//@Entity
@NoArgsConstructor
public class AffinityLabelWithMonths extends AffinityLabelWithWeight<Integer> {
    public AffinityLabelWithMonths(long id, @NonNull String internalName, @NonNull String displayName, @NonNull Integer weightQuantity) {
        super(id, internalName, displayName, weightQuantity, "month");
    }
}
