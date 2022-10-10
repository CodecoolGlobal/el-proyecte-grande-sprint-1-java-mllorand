package com.codecool.elproyectegrande.model;

import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;

//@Entity
@NoArgsConstructor
public class AffinityLabelWithScale extends AffinityLabelWithWeight<Integer> {
    public static final int MINIMUM_SCALE = 1;
    public static final int MAXIMUM_SCALE = 10;

    public AffinityLabelWithScale(long id, String internalName, String displayName, @NonNull Integer weightQuantity) {
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
