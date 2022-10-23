package com.codecool.elproyectegrande.model.coopportunity;

import com.codecool.elproyectegrande.model.label.InterestLabel;
import com.codecool.elproyectegrande.model.label.Tag;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "challengeGenerator")
    @SequenceGenerator(name = "challengeGenerator", sequenceName = "challenge_seq")
    private Long id;

    private @NonNull String description;

    @OneToOne(cascade = {CascadeType.ALL})
    private @NonNull InterestLabel interestLabel;

    @OneToMany(cascade = {CascadeType.MERGE})
    private List<Note> notes;
}
