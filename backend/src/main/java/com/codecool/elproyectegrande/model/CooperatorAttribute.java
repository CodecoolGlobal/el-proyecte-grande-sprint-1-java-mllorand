package com.codecool.elproyectegrande.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

//@Entity
@NoArgsConstructor
@Getter
public class CooperatorAttribute<T> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private T attributeValue;
    @Enumerated(EnumType.STRING)
    private Visibility visibility;

    public CooperatorAttribute(T attributeValue, Visibility visibility) {
        this.attributeValue = attributeValue;
        this.visibility = visibility;
    }
}
