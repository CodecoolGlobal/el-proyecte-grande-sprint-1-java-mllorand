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
public class GenderAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genderGenerator")
    @SequenceGenerator(name = "genderGenerator", sequenceName = "gender_seq")
    protected Long id;

    @NonNull
    private Gender attributeValue;

    @Enumerated(EnumType.STRING)
    private Visibility visibility;
}
