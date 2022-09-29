package com.codecool.elproyectegrande.model;

public class UserAttribute<T> {
    private final T attributeValue;
    private final Visibility visibility;

    public UserAttribute(T attributeValue, Visibility visibility) {
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
