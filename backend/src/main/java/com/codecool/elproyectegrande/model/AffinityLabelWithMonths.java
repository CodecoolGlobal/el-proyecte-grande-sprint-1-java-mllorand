package com.codecool.elproyectegrande.model;


public class AffinityLabelWithMonths extends AffinityLabelWithWeight<Integer> {

    public AffinityLabelWithMonths(long id, String internalName, String displayName, Integer weightQuantity) {
        super(id, internalName, displayName, weightQuantity, "months");
    }
}
