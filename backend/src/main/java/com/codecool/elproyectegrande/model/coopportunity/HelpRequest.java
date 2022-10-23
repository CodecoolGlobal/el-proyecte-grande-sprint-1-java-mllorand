package com.codecool.elproyectegrande.model.coopportunity;

import com.codecool.elproyectegrande.model.label.InterestLabel;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HelpRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "helpRequestGenerator")
    @SequenceGenerator(name = "helpRequestGenerator", sequenceName = "helpRequest_seq")
    private Long id;

    private @NonNull String description;

    @OneToOne(cascade = {CascadeType.ALL})
    private @NonNull InterestLabel interestLabel;
}
