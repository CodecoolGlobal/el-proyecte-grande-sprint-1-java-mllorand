package com.codecool.elproyectegrande.model.coopportunity;

import com.codecool.elproyectegrande.model.*;
import com.codecool.elproyectegrande.model.cooperator.Cooperator;
import com.codecool.elproyectegrande.model.label.InterestLabel;
import com.codecool.elproyectegrande.model.views.FeedView;
import com.fasterxml.jackson.annotation.JsonView;
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

    @JsonView(FeedView.Feed.class)
    private @NonNull String name;

    @JsonView(FeedView.Feed.class)
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

    @JsonView(FeedView.Feed.class)
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Cooperator owner;

    @OneToMany(cascade = {CascadeType.MERGE})
    private @NonNull List<Cooperator> cooperators;

    @OneToOne
    private @NonNull Mission mission;

    @JsonView(FeedView.Feed.class)
    @Enumerated(EnumType.STRING)
    private Visibility visibility;

    @JsonView(FeedView.Feed.class)
    @Enumerated(EnumType.STRING)
    private JoinPolicy joinPolicy;
}
