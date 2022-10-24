package com.codecool.elproyectegrande.model.coopportunity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Gathering {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gatheringGenerator")
    @SequenceGenerator(name = "gatheringGenerator", sequenceName = "gathering_seq")
    private Long id;

    @OneToOne(cascade = {CascadeType.ALL})
    private @NonNull Mission mission;
//    TODO: date
}
