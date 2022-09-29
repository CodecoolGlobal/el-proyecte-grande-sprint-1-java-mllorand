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

    public CooperatorBuilder setUserName(CooperatorAttribute<String> userName) {
        cooperatorUnderBuild.setUserName(userName);
        return this;
    }

    public CooperatorBuilder setEmailAddress(CooperatorAttribute<String> emailAddress) {
        cooperatorUnderBuild.setEmailAddress(emailAddress);
        return this;
    }

    public CooperatorBuilder setFullName(CooperatorAttribute<String> fullName) {
        cooperatorUnderBuild.setFullName(fullName);
        return this;
    }

    public CooperatorBuilder setAge(CooperatorAttribute<Integer> age) {
        cooperatorUnderBuild.setAge(age);
        return this;
    }

    public CooperatorBuilder setGender(CooperatorAttribute<Gender> gender) {
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

    public CooperatorBuilder setInterested(List<AffinityLabelWithScale> interested) {
        cooperatorUnderBuild.setInterested(interested);
        return this;
    }

    public CooperatorBuilder addInterested(AffinityLabelWithScale interested) {
        if(cooperatorUnderBuild.getInterested() == null) {
            cooperatorUnderBuild.setInterested(new LinkedList<>());
        }
        cooperatorUnderBuild.getInterested().add(interested);
        return this;
    }

    public Cooperator build() {
        var tempUser = cooperatorUnderBuild;
        cooperatorUnderBuild = null;
        return tempUser;
    }
}
