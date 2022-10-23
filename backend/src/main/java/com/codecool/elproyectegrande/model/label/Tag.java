package com.codecool.elproyectegrande.model.label;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tagGenerator")
    @SequenceGenerator(name = "tagGenerator", sequenceName = "tag_seq")
    private Long id;

    @NonNull
    private String name;
}
