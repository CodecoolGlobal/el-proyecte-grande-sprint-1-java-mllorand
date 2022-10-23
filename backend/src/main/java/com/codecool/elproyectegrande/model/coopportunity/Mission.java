package com.codecool.elproyectegrande.model.coopportunity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "missionGenerator")
    @SequenceGenerator(name = "missionGenerator", sequenceName = "mission_seq")
    private Long id;

    @NonNull
    private String description;
    @NonNull
    private boolean accomplished = false;
}

