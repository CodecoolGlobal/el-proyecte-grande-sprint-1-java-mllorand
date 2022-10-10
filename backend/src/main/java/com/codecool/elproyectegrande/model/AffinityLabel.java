package com.codecool.elproyectegrande.model;

//import java.awt.Color;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class AffinityLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String internalName;
    @NonNull
    private String toolTipText;

    //private final Color labelColor;
}
