package com.codecool.elproyectegrande.model;

import java.util.List;

public class Cooperator {
    private long id;

    private CooperatorAttribute<String> userName;
    private CooperatorAttribute<String> emailAddress;
    private CooperatorAttribute<String> fullName;
    private CooperatorAttribute<Integer> age;
    private CooperatorAttribute<Gender> gender;

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

    public CooperatorAttribute<String> getUserName() {
        return userName;
    }

    public void setUserName(CooperatorAttribute<String> userName) {
        this.userName = userName;
    }

    public CooperatorAttribute<String> getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(CooperatorAttribute<String> emailAddress) {
        this.emailAddress = emailAddress;
    }

    public CooperatorAttribute<String> getFullName() {
        return fullName;
    }

    public void setFullName(CooperatorAttribute<String> fullName) {
        this.fullName = fullName;
    }

    public CooperatorAttribute<Integer> getAge() {
        return age;
    }

    public void setAge(CooperatorAttribute<Integer> age) {
        this.age = age;
    }

    public CooperatorAttribute<Gender> getGender() {
        return gender;
    }

    public void setGender(CooperatorAttribute<Gender> gender) {
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
