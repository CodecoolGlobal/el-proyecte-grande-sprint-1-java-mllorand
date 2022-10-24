package com.codecool.elproyectegrande.service;

import com.codecool.elproyectegrande.model.cooperator.Cooperator;
import com.codecool.elproyectegrande.model.cooperator.Role;
import com.codecool.elproyectegrande.model.cooperator.attribute.GenderAttribute;
import com.codecool.elproyectegrande.model.cooperator.attribute.AgeAttribute;
import com.codecool.elproyectegrande.model.cooperator.attribute.StringAttribute;
import com.codecool.elproyectegrande.model.customexception.CooperatorNotFoundException;
import com.codecool.elproyectegrande.model.label.InterestLabel;
import com.codecool.elproyectegrande.model.label.SkillLabel;
import com.codecool.elproyectegrande.model.label.TechLabel;
import com.codecool.elproyectegrande.repository.CooperatorRepo;
import com.codecool.elproyectegrande.repository.RoleRepo;
import com.codecool.elproyectegrande.repository.SkillLabelRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CooperatorService implements UserDetailsService {
    private final CooperatorRepo cooperatorRepo;
    private final RoleRepo roleRepo;
    private final SkillLabelRepo skillLabelRepo;
    private final PasswordEncoder passwordEncoder;
    public static final int MINIMUM_AGE = 14;
    public static final int MAXIMUM_AGE = 150;

    public Cooperator findById(Long id) {
        Optional<Cooperator> cooperator = cooperatorRepo.findById(id);
        if (cooperator.isPresent()) return cooperator.get();
        else throw new CooperatorNotFoundException();
    }

    public Cooperator findByName(String name) {
        Cooperator cooperator = cooperatorRepo.findByName(name);
        if (cooperator != null) return cooperator;
        else throw new CooperatorNotFoundException();
    }

    public Cooperator updateName(Cooperator cooperator, String updatedName) {
        cooperator.setName(updatedName);
        return cooperator;
    }

    public Cooperator updateFullName(Cooperator cooperator, StringAttribute updatedFullName) {
        cooperator.setFullName(updatedFullName);
        return cooperator;
    }

    public Cooperator updateGender(Cooperator cooperator, GenderAttribute updatedGender) {
        cooperator.setGender(updatedGender);
        return cooperator;
    }

    public Cooperator updateAge(Cooperator cooperator, AgeAttribute updatedAge) {
        if (updatedAge.getAttributeValue() < MINIMUM_AGE || updatedAge.getAttributeValue() > MAXIMUM_AGE) {
            throw new IllegalArgumentException();
        }
        cooperator.setAge(updatedAge);
        return cooperator;
    }

    public Cooperator updateEmailAddress(Cooperator cooperator, StringAttribute updatedEmailAddress) {
        cooperator.setEmailAddress(updatedEmailAddress);
        return cooperator;
    }

    public Cooperator addNewStrength(Cooperator cooperator, TechLabel newStrength) {
        cooperator.getStrengths().add(newStrength);
        return cooperator;
    }

    public Cooperator addNewLearnFromScratch(Cooperator cooperator, TechLabel newLearnFromScratch) {
        cooperator.getLearnFromScratch().add(newLearnFromScratch);
        return cooperator;
    }

    public Cooperator addNewImproveIn(Cooperator cooperator, TechLabel newImproveIn) {
        cooperator.getImproveIn().add(newImproveIn);
        return cooperator;
    }

    public Cooperator addNewSkill(Cooperator cooperator, @Validated SkillLabel newSkill) {
        skillLabelRepo.save(newSkill);
        log.info("new skill with id: {} created", newSkill.getId());
        cooperator.getSkills().add(newSkill);
        return cooperator;
    }

    public Cooperator addNewInterest(Cooperator cooperator, InterestLabel newInterest) {
        cooperator.getInterests().add(newInterest);
        return cooperator;
    }

    public Iterable<Cooperator> findAll() {
        return cooperatorRepo.findAll();
    }

//    SECURITY

    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Cooperator cooperator = cooperatorRepo.findByName(name);
        if (cooperator == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", name);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        cooperator.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(cooperator.getName(), cooperator.getPassword(), authorities);
    }

    public Cooperator saveUser(Cooperator appUser) {
        log.info("Saving new cooperator {} to the database", appUser.getName());
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return cooperatorRepo.save(appUser);
    }

    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    public void addRoleToUser(String name, String roleName) {
        log.info("Adding role {} to cooperator {}", roleName, name);
        Cooperator appUser = cooperatorRepo.findByName(name);
        Role role = roleRepo.findByName(roleName);
        appUser.getRoles().add(role);
    }

    public Cooperator getUser(String name) {
        log.info("Fetching cooperator {}", name);
        return cooperatorRepo.findByName(name);
    }

    public List<Cooperator> getUsers() {
        log.info("Fetching all cooperators");
        return cooperatorRepo.findAll();
    }

    public Cooperator deleteStrength(Cooperator cooperator, TechLabel strength) {
        cooperator.getStrengths().remove(strength);
        return cooperator;
    }

    public Cooperator deleteLearnFromScratch(Cooperator cooperator, TechLabel learnFromScratch) {
        cooperator.getLearnFromScratch().remove(learnFromScratch);
        return cooperator;
    }

    public Cooperator deleteImproveIn(Cooperator cooperator, TechLabel improveIn) {
        cooperator.getImproveIn().remove(improveIn);
        return cooperator;
    }

    public Cooperator deleteSkill(Cooperator cooperator, SkillLabel skill) {
        cooperator.getSkills().remove(skill);
        return cooperator;
    }

    public Cooperator deleteInterest(Cooperator cooperator, InterestLabel interest) {
        cooperator.getInterests().remove(interest);
        return cooperator;
    }
}

