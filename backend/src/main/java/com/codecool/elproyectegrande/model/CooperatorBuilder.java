package com.codecool.elproyectegrande.model;

import java.util.LinkedList;
import java.util.List;

public class CooperatorBuilder {
    private Cooperator cooperatorUnderBuild;

    public CooperatorBuilder() {
        cooperatorUnderBuild = new Cooperator();
    }

    public CooperatorBuilder setId(long id) {
        cooperatorUnderBuild.setId(id);
        return this;
    }

    public CooperatorBuilder setUserName(StringAttribute userName) {
        cooperatorUnderBuild.setUserName(userName);
        return this;
    }

    public CooperatorBuilder setEmailAddress(StringAttribute emailAddress) {
        cooperatorUnderBuild.setEmailAddress(emailAddress);
        return this;
    }

    public CooperatorBuilder setFullName(StringAttribute fullName) {
        cooperatorUnderBuild.setFullName(fullName);
        return this;
    }

    public CooperatorBuilder setAge(IntegerAttribute age) {
        cooperatorUnderBuild.setAge(age);
        return this;
    }

    public CooperatorBuilder setGender(GenderAttribute gender) {
        cooperatorUnderBuild.setGender(gender);
        return this;
    }

    public CooperatorBuilder setStrengths(List<AffinityLabel> strengths) {
        cooperatorUnderBuild.setStrengths(strengths);
        return this;
    }

    public CooperatorBuilder addStrength(AffinityLabel strength) {
        if(cooperatorUnderBuild.getStrengths() == null) {
            cooperatorUnderBuild.setStrengths(new LinkedList<>());
        }
        cooperatorUnderBuild.getStrengths().add(strength);
        return this;
    }

    public CooperatorBuilder setLearnt(List<AffinityLabelWithMonths> learnt) {
        cooperatorUnderBuild.setLearnt(learnt);
        return this;
    }

    public CooperatorBuilder addLearnt(AffinityLabelWithMonths learnt) {
        if(cooperatorUnderBuild.getLearnt() == null) {
            cooperatorUnderBuild.setLearnt(new LinkedList<>());
        }
        cooperatorUnderBuild.getLearnt().add(learnt);
        return this;
    }

    public CooperatorBuilder setInterested(List<InterestAffinityLabel> interested) {
        cooperatorUnderBuild.setInterested(interested);
        return this;
    }

    public CooperatorBuilder addInterested(InterestAffinityLabel interested) {
        if(cooperatorUnderBuild.getInterested() == null) {
            cooperatorUnderBuild.setInterested(new LinkedList<>());
        }
        cooperatorUnderBuild.getInterested().add(interested);
        return this;
    }

    public CooperatorBuilder setLearnFromScratch(List<AffinityLabel> learnFromScratch) {
        cooperatorUnderBuild.setLearnFromScratch(learnFromScratch);
        return this;
    }

    public CooperatorBuilder addLearnFromScratch(AffinityLabel learnFromScratch) {
        if(cooperatorUnderBuild.getLearnFromScratch() == null) {
            cooperatorUnderBuild.setLearnFromScratch(new LinkedList<>());
        }
        cooperatorUnderBuild.getLearnFromScratch().add(learnFromScratch);
        return this;
    }

    public CooperatorBuilder setImproveIn(List<AffinityLabel> improveIn) {
        cooperatorUnderBuild.setImproveIn(improveIn);
        return this;
    }

    public CooperatorBuilder addImproveIn(AffinityLabel improveIn) {
        if(cooperatorUnderBuild.getImproveIn() == null) {
            cooperatorUnderBuild.setImproveIn(new LinkedList<>());
        }
        cooperatorUnderBuild.getImproveIn().add(improveIn);
        return this;
    }

    public Cooperator build() {
        var tempUser = cooperatorUnderBuild;
        cooperatorUnderBuild = null;
        return tempUser;
    }
}
