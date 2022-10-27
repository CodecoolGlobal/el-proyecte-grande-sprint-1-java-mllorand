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
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tagGenerator")
    @SequenceGenerator(name = "tagGenerator", sequenceName = "tag_seq")
    private Long id;

    @JsonView(FeedView.Feed.class)
    @NonNull
    private String name;
}
