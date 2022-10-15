package com.codecool.elproyectegrande.service;

import com.codecool.elproyectegrande.model.*;
import com.codecool.elproyectegrande.persistance.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@AllArgsConstructor
public class CooperatorProfileService {
    public static final int MINIMUM_AGE = 0;
    public static final int MAXIMUM_AGE = 150;
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

    public void updateGender(GenderAttribute updatedGender) {
        genderAttributeDAO.save(updatedGender);
    }

    public Optional<GenderAttribute> getGender(long userId) {
        var cooperator = cooperatorDAO.findById(userId);
        return cooperator.map(Cooperator::getGender);
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

    public boolean addNewStrength(long userId, AffinityLabel newStrength) {
        var cooperator = cooperatorDAO.findById(userId);
        var affinityLabel = affinityLabelDAO.findById(newStrength.getId());
        if (cooperator.isPresent() && affinityLabel.isPresent()) {
            cooperator.get().getStrengths().add(affinityLabel.get());
            cooperatorDAO.save(cooperator.get());
            return true;
        } else {
            return false;
        }
    }

    public Optional<IntegerAttribute> getAge(long userId) {
        var cooperator = cooperatorDAO.findById(userId);
        return cooperator.map(Cooperator::getAge);
    }

    public void updateAge(IntegerAttribute updatedAge) {
        if (updatedAge.getAttributeValue() < MINIMUM_AGE || updatedAge.getAttributeValue() > MAXIMUM_AGE) {
            throw new IllegalArgumentException();
        }
        integerAttributeDAO.save(updatedAge);
    }

    public boolean addNewLearnFromScratch(long userId, AffinityLabel newLearnFromScratch) {
        var cooperator = cooperatorDAO.findById(userId);
        var affinityLabel = affinityLabelDAO.findById(newLearnFromScratch.getId());
        if (cooperator.isPresent() && affinityLabel.isPresent()) {
            cooperator.get().getLearnFromScratch().add(affinityLabel.get());
            cooperatorDAO.save(cooperator.get());
            return true;
        } else {
            return false;
        }
    }

    public boolean addNewImproveIn(long userId, AffinityLabel newImproveIn) {
        var cooperator = cooperatorDAO.findById(userId);
        var affinityLabel = affinityLabelDAO.findById(newImproveIn.getId());
        if (cooperator.isPresent() && affinityLabel.isPresent()) {
            cooperator.get().getImproveIn().add(affinityLabel.get());
            cooperatorDAO.save(cooperator.get());
            return true;
        } else {
            return false;
        }
    }

    public boolean addNewLearnt(long userId, AffinityLabelWithMonths newLearnt) {
        var cooperator = cooperatorDAO.findById(userId);
        var affinityLabel = affinityLabelDAO.findById(newLearnt.getLabel().getId());
        if (cooperator.isPresent() && affinityLabel.isPresent()) {
            var affinityLabelWithMonths = new AffinityLabelWithMonths(affinityLabel.get(), newLearnt.getWeightQuantity());
            cooperator.get().getLearnt().add(affinityLabelWithMonths);
            cooperatorDAO.save(cooperator.get());
            return true;
        } else {
            return false;
        }
    }

    public boolean addNewInterest(long userId, InterestAffinityLabel newInterest) {
        var cooperator = cooperatorDAO.findById(userId);
        var affinityLabel = affinityLabelDAO.findById(newInterest.getLabel().getId());
        if (cooperator.isPresent() && affinityLabel.isPresent()) {
            var interestAffinityLabel = new InterestAffinityLabel(affinityLabel.get(), newInterest.getInterestPriority());
            cooperator.get().getInterested().add(interestAffinityLabel);
            cooperatorDAO.save(cooperator.get());
            return true;
        } else {
            return false;
        }
    }
}
