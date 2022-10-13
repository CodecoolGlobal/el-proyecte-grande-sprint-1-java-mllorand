package com.codecool.elproyectegrande.model;

//import java.awt.Color;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class AffinityLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "affinityGenerator")
    @SequenceGenerator(name = "affinityGenerator", sequenceName = "affinity_seq")
    private long id;
    @NonNull
    private String internalName;
    @NonNull
    private String toolTipText;

    //private final Color labelColor;
}
