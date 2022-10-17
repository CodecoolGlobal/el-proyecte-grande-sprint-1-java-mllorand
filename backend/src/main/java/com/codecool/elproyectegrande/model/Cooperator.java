package com.codecool.elproyectegrande.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Cooperator {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cooperatorGenerator")
    @SequenceGenerator(name = "cooperatorGenerator", sequenceName = "cooperator_seq")
    private long id;

    @OneToOne
    private @NonNull StringAttribute userName;
    @OneToOne
    private @NonNull StringAttribute emailAddress;
    @OneToOne
    private StringAttribute fullName;
    @OneToOne
    private IntegerAttribute age;
    @OneToOne
    private GenderAttribute gender;

    @OneToMany
    private List<AffinityLabel> strengths;
    @OneToMany(cascade = {CascadeType.MERGE})
    private List<AffinityLabelWithMonths> learnt;
    @OneToMany(cascade = {CascadeType.MERGE})
    private List<InterestAffinityLabel> interested;
    @OneToMany
    private List<AffinityLabel> learnFromScratch;
    @OneToMany
    private List<AffinityLabel> improveIn;

    //groups

}
