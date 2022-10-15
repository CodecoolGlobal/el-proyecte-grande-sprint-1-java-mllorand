package com.codecool.elproyectegrande.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@MappedSuperclass
public class AffinityLabelWithWeight<W> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "affinityWeightGenerator")
    @SequenceGenerator(name = "affinityWeightGenerator", sequenceName = "affinity_weight_seq")
    @JsonIgnore
    private long id;

    @NonNull
    @ManyToOne
    private AffinityLabel label;

    @NonNull
    private W weightQuantity;
    @NonNull
    private String weightUnit;

    public AffinityLabelWithWeight(AffinityLabel label, W weightQuantity, String weightUnit) {
        this.label = label;
        this.weightQuantity = weightQuantity;
        this.weightUnit = weightUnit;
    }
}
