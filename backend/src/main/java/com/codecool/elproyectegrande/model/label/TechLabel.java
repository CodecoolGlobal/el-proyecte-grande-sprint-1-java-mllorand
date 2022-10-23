package com.codecool.elproyectegrande.model.label;


import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TechLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "techLabelGenerator")
    @SequenceGenerator(name = "techLabelGenerator", sequenceName = "techLabel_seq")
    private Long id;
    @NonNull
    private String internalName;
    @NonNull
    private String toolTipText;
}
