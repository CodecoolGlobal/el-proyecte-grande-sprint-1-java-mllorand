package com.codecool.elproyectegrande.model;

import lombok.*;

import javax.persistence.Entity;

//@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class AffinityLabelWithWeight<W> extends AffinityLabel {
    @NonNull
    private W weightQuantity;
    @NonNull
    private String weightUnit;

    public AffinityLabelWithWeight(long id, @NonNull String internalName, @NonNull String displayName, @NonNull W weightQuantity, @NonNull String weightUnit) {
        super(id, internalName, displayName);
        this.weightQuantity = weightQuantity;
        this.weightUnit = weightUnit;
    }
}
