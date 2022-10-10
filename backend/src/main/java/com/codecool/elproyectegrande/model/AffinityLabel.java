package com.codecool.elproyectegrande.model;

//import java.awt.Color;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Builder
public class AffinityLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String internalName;
    @NonNull
    private String displayName;

    //private final Color labelColor;

    public AffinityLabel(long id, String internalName, String displayName) {
        this.id = id;
        this.internalName = internalName;
        this.displayName = displayName;
    }
}
