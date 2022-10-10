package com.codecool.elproyectegrande.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;

//@Entity
@NoArgsConstructor
@Getter
public class AffinityLabelWithPresetValues<E> extends AffinityLabel{
    private E interestPriority;

    public AffinityLabelWithPresetValues(long id, @NonNull String internalName, @NonNull String toolTipText, E interestPriority) {
        super(id, internalName, toolTipText);
        this.interestPriority = interestPriority;
    }
}
