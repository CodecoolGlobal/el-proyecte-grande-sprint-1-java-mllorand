package com.codecool.elproyectegrande.model;

import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class AffinityLabelWithMonths extends AffinityLabelWithWeight<Integer> {
    public AffinityLabelWithMonths(long id, @NonNull AffinityLabel label, @NonNull Integer weightQuantity) {
        super(id, label, weightQuantity, "month");
    }

    public AffinityLabelWithMonths(AffinityLabel label, Integer weightQuantity) {
        super(label, weightQuantity, "month");
    }
}
