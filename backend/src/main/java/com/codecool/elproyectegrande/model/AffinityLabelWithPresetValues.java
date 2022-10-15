package com.codecool.elproyectegrande.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@MappedSuperclass
public class AffinityLabelWithPresetValues<E> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "affinityPresetGenerator")
    @SequenceGenerator(name = "affinityPresetGenerator", sequenceName = "affinity_preset_seq")
    private long id;

    @ManyToOne
    private AffinityLabel label;

    private E interestPriority;

    public AffinityLabelWithPresetValues(AffinityLabel label, E interestPriority) {
        this.label = label;
        this.interestPriority = interestPriority;
    }
}
