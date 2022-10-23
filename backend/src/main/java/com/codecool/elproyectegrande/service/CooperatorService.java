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

    public Cooperator updateName(Long id, String updatedName) {
        var cooperator = findById(id);
        cooperator.setName(updatedName);
        return cooperator;
    }

    public Cooperator updateFullName(Long id, StringAttribute updatedFullName) {
        var cooperator = findById(id);
        cooperator.setFullName(updatedFullName);
        return cooperator;
    }

    public Cooperator updateGender(Long id, GenderAttribute updatedGender) {
        var cooperator = findById(id);
        cooperator.setGender(updatedGender);
        return cooperator;
    }

    public Cooperator updateAge(Long id, AgeAttribute updatedAge) {
        var cooperator = findById(id);
        if (updatedAge.getAttributeValue() < MINIMUM_AGE || updatedAge.getAttributeValue() > MAXIMUM_AGE) {
            throw new IllegalArgumentException();
        }
        cooperator.setAge(updatedAge);
        return cooperator;
    }

    public Cooperator updateEmailAddress(Long id, StringAttribute updatedEmailAddress) {
        Cooperator cooperator = findById(id);
        cooperator.setEmailAddress(updatedEmailAddress);
        return cooperator;
    }

    public Cooperator addNewStrength(Long id, TechLabel newStrength) {
        var cooperator = findById(id);
        cooperator.getStrengths().add(newStrength);
        return cooperator;
    }

    public Cooperator addNewLearnFromScratch(Long id, TechLabel newLearnFromScratch) {
        var cooperator = findById(id);
        cooperator.getLearnFromScratch().add(newLearnFromScratch);
        return cooperator;
    }

    public Cooperator addNewImproveIn(Long id, TechLabel newImproveIn) {
        var cooperator = findById(id);
        cooperator.getImproveIn().add(newImproveIn);
        return cooperator;
    }

    public Cooperator addNewSkill(Long id, @Validated SkillLabel newSkill) {
        skillLabelRepo.save(newSkill);
        log.info("new skill with id: {} created", newSkill.getId());
        var cooperator = findById(id);
        cooperator.getSkills().add(newSkill);
        return cooperator;
    }

    public Cooperator addNewInterest(Long id, InterestLabel newInterest) {
        var cooperator = findById(id);
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
}

