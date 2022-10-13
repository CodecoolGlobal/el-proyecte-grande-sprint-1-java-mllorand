package com.codecool.elproyectegrande.model;

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
    private long id;

    @NonNull
    @ManyToOne
    private AffinityLabel label;

    @NonNull
    private W weightQuantity;
    @NonNull
    private String weightUnit;

}
