package com.codecool.elproyectegrande.model;

public class CooperatorAttribute<T> {
    private final T attributeValue;
    private final Visibility visibility;

    public CooperatorAttribute(T attributeValue, Visibility visibility) {
        this.attributeValue = attributeValue;
        this.visibility = visibility;
    }

    public T getAttributeValue() {
        return attributeValue;
    }

    public Visibility getVisibility() {
        return visibility;
    }
}
