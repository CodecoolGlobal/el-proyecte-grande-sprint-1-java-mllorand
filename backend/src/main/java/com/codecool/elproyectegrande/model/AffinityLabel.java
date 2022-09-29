package com.codecool.elproyectegrande.model;

//import java.awt.Color;

public class AffinityLabel {
    private final String internalName;
    private final String displayName;

    //private final Color labelColor;


    public AffinityLabel(String internalName, String displayName) {
        this.internalName = internalName;
        this.displayName = displayName;
    }

    public String getInternalName() {
        return internalName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
