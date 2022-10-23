package com.codecool.elproyectegrande.model.cooperator.attribute;

import com.codecool.elproyectegrande.model.Visibility;
import com.codecool.elproyectegrande.model.cooperator.Gender;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StringAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stringGenerator")
    @SequenceGenerator(name = "stringGenerator", sequenceName = "string_seq")
    protected Long id;

    @NonNull
    private String attributeValue;

    @Enumerated(EnumType.STRING)
    private Visibility visibility;
}