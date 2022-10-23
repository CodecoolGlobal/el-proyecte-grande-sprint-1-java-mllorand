package com.codecool.elproyectegrande.model.coopportunity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "noteGenerator")
    @SequenceGenerator(name = "noteGenerator", sequenceName = "note_seq")
    private Long id;

    private @NonNull String name;
    private @NonNull String text;
}
