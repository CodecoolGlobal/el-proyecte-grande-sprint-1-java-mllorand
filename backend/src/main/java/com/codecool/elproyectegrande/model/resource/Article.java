package com.codecool.elproyectegrande.model.resource;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "articleGenerator")
    @SequenceGenerator(name = "articleGenerator", sequenceName = "article_seq")
    private Long id;

//    Todo:
//     find out how to save text of article
//     files for example
    @NonNull
    private String text;

    private String sources;
}
