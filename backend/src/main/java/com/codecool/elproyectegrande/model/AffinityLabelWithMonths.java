package com.codecool.elproyectegrande.model;


public class AffinityLabelWithMonths extends AffinityLabelWithWeight<Integer> {

    public AffinityLabelWithMonths(String internalName, String displayName, Integer weightQuantity) {
        super(internalName, displayName, weightQuantity, "months");
    }
}
