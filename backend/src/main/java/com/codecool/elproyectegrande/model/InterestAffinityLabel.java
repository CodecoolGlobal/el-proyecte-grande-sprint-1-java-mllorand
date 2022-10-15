package com.codecool.elproyectegrande.model;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
public class InterestAffinityLabel extends AffinityLabelWithPresetValues<InterestPriority>{
    public InterestAffinityLabel(long id, AffinityLabel label, InterestPriority interestPriority) {
        super(id, label, interestPriority);
    }

    public InterestAffinityLabel(AffinityLabel affinityLabel, InterestPriority interestPriority) {
        super(affinityLabel, interestPriority);
    }
}
