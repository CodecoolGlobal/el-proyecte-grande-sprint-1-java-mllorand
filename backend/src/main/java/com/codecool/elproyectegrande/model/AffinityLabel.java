package com.codecool.elproyectegrande.model;

//import java.awt.Color;

public class AffinityLabel {
    private final long id;
    private final String internalName;
    private final String displayName;

    //private final Color labelColor;


    public AffinityLabel(long id, String internalName, String displayName) {
        this.id = id;
        this.internalName = internalName;
        this.displayName = displayName;
    }

    public long getId() {
        return id;
    }

    public String getInternalName() {
        return internalName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
