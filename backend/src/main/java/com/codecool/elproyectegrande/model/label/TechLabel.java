package com.codecool.elproyectegrande.model.label;


import com.codecool.elproyectegrande.model.views.FeedView;
import com.fasterxml.jackson.annotation.JsonView;
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
    @JsonView(FeedView.Feed.class)
    @NonNull
    private String internalName;
    @JsonView(FeedView.Feed.class)
    @NonNull
    private String toolTipText;
}
