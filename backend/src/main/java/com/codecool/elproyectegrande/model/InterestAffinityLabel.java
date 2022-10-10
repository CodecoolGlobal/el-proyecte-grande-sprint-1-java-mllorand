package com.codecool.elproyectegrande.model;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
public class InterestAffinityLabel extends AffinityLabelWithPresetValues<InterestPriority>{
    public InterestAffinityLabel(long id, @NonNull String internalName, @NonNull String toolTipText, InterestPriority interestPriority) {
        super(id, internalName, toolTipText, interestPriority);
    }
}
