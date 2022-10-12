package com.codecool.elproyectegrande.service;

import com.codecool.elproyectegrande.model.Cooperator;
import com.codecool.elproyectegrande.model.StringAttribute;
import com.codecool.elproyectegrande.persistance.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CooperatorProfileService {
    private CooperatorDAO cooperatorDAO;
    private AffinityLabelDAO affinityLabelDAO;
    private AffinityLabelWithMonthsDAO affinityLabelWithMonthsDAO;
    private InterestAffinityLabelDAO interestAffinityLabelDAO;
    private GenderAttributeDAO genderAttributeDAO;
    private IntegerAttributeDAO integerAttributeDAO;
    private StringAttributeDAO stringAttributeDAO;

    public <S extends Cooperator> S save(S entity) {
        return cooperatorDAO.save(entity);
    }

    public <S extends Cooperator> Iterable<S> saveAll(Iterable<S> entities) {
        return cooperatorDAO.saveAll(entities);
    }

    public Optional<Cooperator> findById(Long aLong) {
        return cooperatorDAO.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return cooperatorDAO.existsById(aLong);
    }

    public Iterable<Cooperator> findAll() {
        return cooperatorDAO.findAll();
    }

    public long count() {
        return cooperatorDAO.count();
    }

    public void deleteById(Long aLong) {
        cooperatorDAO.deleteById(aLong);
    }

    public void delete(Cooperator entity) {
        cooperatorDAO.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Long> longs) {
        cooperatorDAO.deleteAllById(longs);
    }

    public void deleteAll(Iterable<? extends Cooperator> entities) {
        cooperatorDAO.deleteAll(entities);
    }

    public void deleteAll() {
        cooperatorDAO.deleteAll();
    }

    public Optional<StringAttribute> getUserName(long userId) {
        var cooperator = cooperatorDAO.findById(userId);
        return cooperator.map(Cooperator::getUserName);
    }

    public void updateUserName(StringAttribute updatedUserName) {
        stringAttributeDAO.save(updatedUserName);
    }

    public Optional<StringAttribute> getEmailAddress(long userId) {
        var cooperator = cooperatorDAO.findById(userId);
        return cooperator.map(Cooperator::getEmailAddress);
    }

    public void updateEmailAddress(StringAttribute updatedEmailAddress) {
        stringAttributeDAO.save(updatedEmailAddress);
    }

    public Optional<StringAttribute> getFullName(long userId) {
        var cooperator = cooperatorDAO.findById(userId);
        return cooperator.map(Cooperator::getFullName);
    }

    public void updateFullName(StringAttribute updatedFullName) {
        stringAttributeDAO.save(updatedFullName);
    }
}
