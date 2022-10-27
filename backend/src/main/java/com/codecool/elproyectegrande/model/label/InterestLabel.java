package com.codecool.elproyectegrande.model.label;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InterestLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interestLabelGenerator")
    @SequenceGenerator(name = "interestLabelGenerator", sequenceName = "interestLabel_seq")
    private Long id;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private TechLabel label;

    @OneToMany(cascade = {CascadeType.MERGE})
    private List<Tag> tags;

    @Enumerated(EnumType.STRING)
    private InterestPriority interestPriority;
}

