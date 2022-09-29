package com.codecool.elproyectegrande.model;

public class AffinityLabelWithWeight<W> extends AffinityLabel {
    private final W weightQuantity;
    private final String weightUnit;

    public AffinityLabelWithWeight(long id, String internalName, String displayName, W weightQuantity, String weightUnit) {
        super(id, internalName, displayName);
        this.weightQuantity = weightQuantity;
        this.weightUnit = weightUnit;
    }

    public W getWeightQuantity() {
        return weightQuantity;
    }

    public String getWeightUnit() {
        return weightUnit;
    }
}
