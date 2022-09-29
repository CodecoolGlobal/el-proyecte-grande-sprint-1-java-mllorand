package com.codecool.elproyectegrande.model;

import java.util.LinkedList;
import java.util.List;

public class UserBuilder {
    private Cooperator cooperatorUnderBuild;

    public UserBuilder() {
        cooperatorUnderBuild = new Cooperator();
    }

    public UserBuilder setId(long id) {
        cooperatorUnderBuild.setId(id);
        return this;
    }

    public UserBuilder setUserName(CooperatorAttribute<String> userName) {
        cooperatorUnderBuild.setUserName(userName);
        return this;
    }

    public UserBuilder setEmailAddress(CooperatorAttribute<String> emailAddress) {
        cooperatorUnderBuild.setEmailAddress(emailAddress);
        return this;
    }

    public UserBuilder setFullName(CooperatorAttribute<String> fullName) {
        cooperatorUnderBuild.setFullName(fullName);
        return this;
    }

    public UserBuilder setAge(CooperatorAttribute<Integer> age) {
        cooperatorUnderBuild.setAge(age);
        return this;
    }

    public UserBuilder setGender(CooperatorAttribute<Gender> gender) {
        cooperatorUnderBuild.setGender(gender);
        return this;
    }

    public UserBuilder setStrengths(List<AffinityLabel> strengths) {
        cooperatorUnderBuild.setStrengths(strengths);
        return this;
    }

    public UserBuilder addStrength(AffinityLabel strength) {
        if(cooperatorUnderBuild.getStrengths() == null) {
            cooperatorUnderBuild.setStrengths(new LinkedList<>());
        }
        cooperatorUnderBuild.getStrengths().add(strength);
        return this;
    }

    public UserBuilder setLearnt(List<AffinityLabelWithMonths> learnt) {
        cooperatorUnderBuild.setLearnt(learnt);
        return this;
    }

    public UserBuilder addLearnt(AffinityLabelWithMonths learnt) {
        if(cooperatorUnderBuild.getLearnt() == null) {
            cooperatorUnderBuild.setLearnt(new LinkedList<>());
        }
        cooperatorUnderBuild.getLearnt().add(learnt);
        return this;
    }

    public UserBuilder setInterested(List<AffinityLabelWithScale> interested) {
        cooperatorUnderBuild.setInterested(interested);
        return this;
    }

    public UserBuilder addInterested(AffinityLabelWithScale interested) {
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
