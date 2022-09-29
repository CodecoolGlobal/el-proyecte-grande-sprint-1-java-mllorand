package com.codecool.elproyectegrande.model;

public class AffinityLabelWithWeight<W> extends AffinityLabel {
    private final W weightQuantity;
    private final String weightUnit;

    public AffinityLabelWithWeight(String internalName, String displayName, W weightQuantity, String weightUnit) {
        super(internalName, displayName);
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
