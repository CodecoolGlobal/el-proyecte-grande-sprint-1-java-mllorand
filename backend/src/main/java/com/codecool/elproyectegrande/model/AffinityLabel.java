package com.codecool.elproyectegrande.model;

//import java.awt.Color;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private long id;
    @NonNull
    private String internalName;
    @NonNull
    private String toolTipText;

    //private final Color labelColor;
}
