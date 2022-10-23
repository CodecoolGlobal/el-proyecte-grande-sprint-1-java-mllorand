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
public class AgeAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ageGenerator")
    @SequenceGenerator(name = "ageGenerator", sequenceName = "age_seq")
    protected Long id;

    @NonNull
    private Integer attributeValue;

    @Enumerated(EnumType.STRING)
    private Visibility visibility;
}
