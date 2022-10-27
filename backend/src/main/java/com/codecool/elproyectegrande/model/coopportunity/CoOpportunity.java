package com.codecool.elproyectegrande.model.coopportunity;

import com.codecool.elproyectegrande.model.*;
import com.codecool.elproyectegrande.model.cooperator.Cooperator;
import com.codecool.elproyectegrande.model.label.InterestLabel;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CoOpportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coOpportunityGenerator")
    @SequenceGenerator(name = "coOpportunityGenerator", sequenceName = "coOpportunity_seq")
    private Long id;

    private @NonNull String name;

    @OneToMany(cascade = {CascadeType.MERGE})
    private List<InterestLabel> interestLabels;

    @OneToMany(cascade = {CascadeType.MERGE})
    private List<Gathering> gatherings;

    @OneToMany(cascade = {CascadeType.MERGE})
    private List<Challenge> challenges;

    @OneToMany(cascade = {CascadeType.MERGE})
    private List<Note> notes;

    @OneToMany(cascade = {CascadeType.MERGE})
    private List<HelpRequest> helpRequests;

    @OneToMany(cascade = {CascadeType.MERGE})
    private List<Repo> repos;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Cooperator owner;

    @OneToMany(cascade = {CascadeType.MERGE})
    private @NonNull List<Cooperator> cooperators;

    @OneToOne
    private @NonNull Mission mission;

    @Enumerated(EnumType.STRING)
    private Visibility visibility;

    @Enumerated(EnumType.STRING)
    private JoinPolicy joinPolicy;
}
