package com.codecool.elproyectegrande.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@MappedSuperclass
public class CooperatorAttribute<T> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attributeGenerator")
    @SequenceGenerator(name = "attributeGenerator", sequenceName = "attribute_seq")
    @Setter
    protected long id;
    @NonNull
    private T attributeValue;
    @Enumerated(EnumType.STRING)
    private Visibility visibility;

    public CooperatorAttribute(long id, T attributeValue, Visibility visibility) {
        this.id = id;
        this.attributeValue = attributeValue;
        this.visibility = visibility;
    }
}
