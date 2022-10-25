package com.codecool.elproyectegrande.repository;

import com.codecool.elproyectegrande.model.*;
import com.codecool.elproyectegrande.model.cooperator.Cooperator;
import com.codecool.elproyectegrande.model.cooperator.Gender;
import com.codecool.elproyectegrande.model.cooperator.Role;
import com.codecool.elproyectegrande.model.cooperator.attribute.GenderAttribute;
import com.codecool.elproyectegrande.model.cooperator.attribute.AgeAttribute;
import com.codecool.elproyectegrande.model.cooperator.attribute.StringAttribute;
import com.codecool.elproyectegrande.model.coopportunity.CoOpportunity;
import com.codecool.elproyectegrande.model.label.*;
import com.codecool.elproyectegrande.service.CooperatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class DatabaseInitializer implements CommandLineRunner {
    private final CooperatorRepo cooperatorRepo;
    private final CoOpportunityRepo coOpportunityRepo;
    private final InterestLabelRepo interestLabelRepo;
    private final ResourceRepo resourceRepo;
    private final SkillLabelRepo skillLabelRepo;
    private final TagRepo tagRepo;
    private final TechLabelRepo techLabelRepo;
    private final CooperatorService cooperatorService;
    private final RoleRepo roleRepo;
    
    @Override
    public void run(String... args) throws Exception {
        TechLabel jsLabel, javaLabel, reactLabel, dockerLabel;
        if (techLabelRepo.count() <= 0) {
            jsLabel = new TechLabel(null, "js", "javascript");
            javaLabel = new TechLabel(null, "java", "Java");
            reactLabel = new TechLabel(null, "react", "React");
            dockerLabel = new TechLabel(null, "docker", "Docker");
            techLabelRepo.saveAll(List.of(jsLabel, javaLabel, reactLabel, dockerLabel));
        } else {
            jsLabel = techLabelRepo.findById(1L).get();
            javaLabel = techLabelRepo.findById(2L).get();
            reactLabel = techLabelRepo.findById(3L).get();
            dockerLabel = techLabelRepo.findById(4L).get();
        }

        if (cooperatorRepo.count() <= 0) {
            String name = "anthony2";
            StringAttribute fullName = new StringAttribute(null, "Anthony Miller", Visibility.PUBLIC);
            StringAttribute emailAddress = new StringAttribute(null, "anthony2@gmail.com", Visibility.PRIVATE);
            AgeAttribute age = new AgeAttribute(null, 35, Visibility.PRIVATE);
            GenderAttribute gender = new GenderAttribute(null, Gender.MALE, Visibility.PUBLIC);

            var skills = new ArrayList<SkillLabel>();
            var interests = new ArrayList<InterestLabel>();
            var strengths = new ArrayList<TechLabel>();
            var learnFromScratch = new ArrayList<TechLabel>();
            var improveIn = new ArrayList<TechLabel>();
            var coOpportunities = new ArrayList<CoOpportunity>();
            var password = "1234";
            var roles = new ArrayList<Role>();
            var role = new Role(null, "ROLE_COOPERATOR");
            roleRepo.save(role);
            roles.add(role);

            var userAnthony = new Cooperator(null, name, emailAddress, fullName, age, gender, skills, interests, strengths, learnFromScratch, improveIn, coOpportunities, password, roles);
            cooperatorService.saveUser(userAnthony);
        }
    }
}
