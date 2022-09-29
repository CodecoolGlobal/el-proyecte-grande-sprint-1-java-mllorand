package com.codecool.elproyectegrande.model;

public class AffinityLabelWithScale extends AffinityLabelWithWeight<Integer> {
    private static final int MINIMUM_SCALE = 1;
    private static final int MAXIMUM_SCALE = 10;

    public AffinityLabelWithScale(long id, String internalName, String displayName, Integer weightQuantity) {
        super(id, internalName, displayName, weightQuantity, "");
        if (weightQuantity < MINIMUM_SCALE || weightQuantity > MAXIMUM_SCALE) {
            throw new LabelScaleOutOfBounds(
                String.format("Label scale cannot be lesser than %d and greater than %d",
                    MINIMUM_SCALE,
                    MAXIMUM_SCALE)
            );
        }
    }
}
