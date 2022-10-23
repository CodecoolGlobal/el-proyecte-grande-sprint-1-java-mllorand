package com.codecool.elproyectegrande.model.label;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SkillLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skillLabelGenerator")
    @SequenceGenerator(name = "skillLabelGenerator", sequenceName = "skillLabel_seq")
    private Long id;

    @NonNull
    @ManyToOne(cascade = {CascadeType.MERGE})
    private TechLabel label;

    @NonNull
    private int skillQuantity;

    @NonNull
    @Enumerated(EnumType.STRING)
    private SkillUnit skillUnit;

}
