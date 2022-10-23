package com.codecool.elproyectegrande.model.coopportunity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Repo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "repoGenerator")
    @SequenceGenerator(name = "repoGenerator", sequenceName = "repo_seq")
    private Long id;

    private @NonNull String description;
    private @NonNull String githubLink;
}
