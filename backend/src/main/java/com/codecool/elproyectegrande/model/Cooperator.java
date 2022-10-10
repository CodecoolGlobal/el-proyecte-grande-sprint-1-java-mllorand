package com.codecool.elproyectegrande.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

//@Entity
@NoArgsConstructor
@Getter
@Setter
public class Cooperator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @OneToOne
    private CooperatorAttribute<String> userName;
    @NonNull
    @OneToOne
    private CooperatorAttribute<String> emailAddress;
    @OneToOne
    private CooperatorAttribute<String> fullName;
    @OneToOne
    private CooperatorAttribute<Integer> age;
    @OneToOne
    private CooperatorAttribute<Gender> gender;

    @OneToMany
    private List<AffinityLabel> strengths;
    @OneToMany
    private List<AffinityLabelWithMonths> learnt;
    @OneToMany
    private List<AffinityLabelWithPresetValues<InterestPriority>> interested;
    @OneToMany
    private List<AffinityLabel> learnFromScratch;
    @OneToMany
    private List<AffinityLabel> improveIn;

    //groups

}
