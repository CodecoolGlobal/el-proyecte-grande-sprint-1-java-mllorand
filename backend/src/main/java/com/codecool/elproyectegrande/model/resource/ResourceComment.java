package com.codecool.elproyectegrande.model.resource;

import com.codecool.elproyectegrande.model.cooperator.Cooperator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResourceComment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resourceCommentGenerator")
    @SequenceGenerator(name = "resourceCommentGenerator", sequenceName = "resourceComment_seq")
    private Long id;

    @OneToOne(cascade = {CascadeType.ALL})
    private Article article;

    @OneToOne(cascade = {CascadeType.ALL})
    private Cooperator author;

    private int upVotes;
    private int downVotes;
}
