package com.codecool.elproyectegrande.model.resource;

import com.codecool.elproyectegrande.model.cooperator.Cooperator;
import com.codecool.elproyectegrande.model.label.InterestLabel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resourceGenerator")
    @SequenceGenerator(name = "resourceGenerator", sequenceName = "resource_seq")
    private Long id;

    @OneToOne(cascade = {CascadeType.ALL})
    private Article article;

    @OneToOne(cascade = {CascadeType.ALL})
    private InterestLabel interestLabel;

    @OneToOne(cascade = {CascadeType.ALL})
    private Cooperator author;

    @OneToMany(cascade = {CascadeType.MERGE})
    private List<ResourceComment> comments;

    private int upVotes;
    private int downVotes;
}
