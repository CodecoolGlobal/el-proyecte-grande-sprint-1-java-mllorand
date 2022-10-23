package com.codecool.elproyectegrande.model.cooperator;

import com.codecool.elproyectegrande.model.cooperator.attribute.GenderAttribute;
import com.codecool.elproyectegrande.model.cooperator.attribute.AgeAttribute;
import com.codecool.elproyectegrande.model.cooperator.attribute.StringAttribute;
import com.codecool.elproyectegrande.model.coopportunity.CoOpportunity;
import com.codecool.elproyectegrande.model.label.InterestLabel;
import com.codecool.elproyectegrande.model.label.SkillLabel;
import com.codecool.elproyectegrande.model.label.TechLabel;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Cooperator {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cooperatorGenerator")
    @SequenceGenerator(name = "cooperatorGenerator", sequenceName = "cooperator_seq")
    private Long id;

    private @NonNull String name;

    @OneToOne(cascade = {CascadeType.ALL})
    private @NonNull StringAttribute emailAddress;

    @OneToOne(cascade = {CascadeType.ALL})
    private StringAttribute fullName;

    @OneToOne(cascade = {CascadeType.ALL})
    private AgeAttribute age;

    @OneToOne(cascade = {CascadeType.ALL})
    private GenderAttribute gender;

    @OneToMany(cascade = {CascadeType.MERGE})
    private List<SkillLabel> skills;

    @OneToMany(cascade = {CascadeType.MERGE})
    private List<InterestLabel> interests;

    @OneToMany(cascade = {CascadeType.MERGE})
    private List<TechLabel> strengths;

    @OneToMany(cascade = {CascadeType.MERGE})
    private List<TechLabel> learnFromScratch;

    @OneToMany(cascade = {CascadeType.MERGE})
    private List<TechLabel> improveIn;

    @OneToMany(cascade = {CascadeType.MERGE})
    private List<CoOpportunity> coOpportunities;

    private String password;

    @ManyToMany(fetch = EAGER, cascade = {CascadeType.MERGE})
    private Collection<Role> roles = new ArrayList<>();
}
