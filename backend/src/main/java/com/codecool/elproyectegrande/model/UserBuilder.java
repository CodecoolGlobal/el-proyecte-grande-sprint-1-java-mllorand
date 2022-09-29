package com.codecool.elproyectegrande.model;

import java.util.List;

public class UserBuilder {
    private User userUnderBuild;

    public UserBuilder() {
        userUnderBuild = new User();
    }

    public UserBuilder setId(long id) {
        userUnderBuild.setId(id);
        return this;
    }

    public UserBuilder setUserName(UserAttribute<String> userName) {
        userUnderBuild.setUserName(userName);
        return this;
    }

    public UserBuilder setEmailAddress(UserAttribute<String> emailAddress) {
        userUnderBuild.setEmailAddress(emailAddress);
        return this;
    }

    public UserBuilder setFullName(UserAttribute<String> fullName) {
        userUnderBuild.setFullName(fullName);
        return this;
    }

    public UserBuilder setAge(UserAttribute<Integer> age) {
        userUnderBuild.setAge(age);
        return this;
    }

    public UserBuilder setGender(UserAttribute<Gender> gender) {
        userUnderBuild.setGender(gender);
        return this;
    }

    public UserBuilder setStrengths(List<AffinityLabel> strengths) {
        userUnderBuild.setStrengths(strengths);
        return this;
    }

    public UserBuilder addStrength(AffinityLabel strength) {
        userUnderBuild.getStrengths().add(strength);
        return this;
    }

    public UserBuilder setLearnt(List<AffinityLabelWithMonths> learnt) {
        userUnderBuild.setLearnt(learnt);
        return this;
    }

    public UserBuilder addLearnt(AffinityLabelWithMonths learnt) {
        userUnderBuild.getLearnt().add(learnt);
        return this;
    }

    public UserBuilder setInterested(List<AffinityLabelWithScale> interested) {
        userUnderBuild.setInterested(interested);
        return this;
    }

    public UserBuilder addInterested(AffinityLabelWithScale interested) {
        userUnderBuild.getInterested().add(interested);
        return this;
    }

    public User build() {
        var tempUser = userUnderBuild;
        userUnderBuild = null;
        return tempUser;
    }
}
