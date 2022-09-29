package com.codecool.elproyectegrande.model;

import java.util.List;

public class Cooperator {
    private long id;

    private UserAttribute<String> userName;
    private UserAttribute<String> emailAddress;
    private UserAttribute<String> fullName;
    private UserAttribute<Integer> age;
    private UserAttribute<Gender> gender;

    private List<AffinityLabel> strengths;
    private List<AffinityLabelWithMonths> learnt;
    private List<AffinityLabelWithScale> interested;

    //groups


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserAttribute<String> getUserName() {
        return userName;
    }

    public void setUserName(UserAttribute<String> userName) {
        this.userName = userName;
    }

    public UserAttribute<String> getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(UserAttribute<String> emailAddress) {
        this.emailAddress = emailAddress;
    }

    public UserAttribute<String> getFullName() {
        return fullName;
    }

    public void setFullName(UserAttribute<String> fullName) {
        this.fullName = fullName;
    }

    public UserAttribute<Integer> getAge() {
        return age;
    }

    public void setAge(UserAttribute<Integer> age) {
        this.age = age;
    }

    public UserAttribute<Gender> getGender() {
        return gender;
    }

    public void setGender(UserAttribute<Gender> gender) {
        this.gender = gender;
    }

    public List<AffinityLabel> getStrengths() {
        return strengths;
    }

    public void setStrengths(List<AffinityLabel> strengths) {
        this.strengths = strengths;
    }

    public List<AffinityLabelWithMonths> getLearnt() {
        return learnt;
    }

    public void setLearnt(List<AffinityLabelWithMonths> learnt) {
        this.learnt = learnt;
    }

    public List<AffinityLabelWithScale> getInterested() {
        return interested;
    }

    public void setInterested(List<AffinityLabelWithScale> interested) {
        this.interested = interested;
    }
}
