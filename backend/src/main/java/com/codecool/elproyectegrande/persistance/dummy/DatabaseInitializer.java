package com.codecool.elproyectegrande.persistance.dummy;

import com.codecool.elproyectegrande.model.*;
import com.codecool.elproyectegrande.persistance.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.StreamSupport;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    private CooperatorDAO cooperatorDAO;
    private AffinityLabelDAO affinityLabelDAO;
    private AffinityLabelWithMonthsDAO affinityLabelWithMonthsDAO;
    private InterestAffinityLabelDAO interestAffinityLabelDAO;
    private GenderAttributeDAO genderAttributeDAO;
    private IntegerAttributeDAO integerAttributeDAO;
    private StringAttributeDAO stringAttributeDAO;

    public DatabaseInitializer(CooperatorDAO cooperatorDAO, AffinityLabelDAO affinityLabelDAO, AffinityLabelWithMonthsDAO affinityLabelWithMonthsDAO, InterestAffinityLabelDAO interestAffinityLabelDAO, GenderAttributeDAO genderAttributeDAO, IntegerAttributeDAO integerAttributeDAO, StringAttributeDAO stringAttributeDAO) {
        this.cooperatorDAO = cooperatorDAO;
        this.affinityLabelDAO = affinityLabelDAO;
        this.affinityLabelWithMonthsDAO = affinityLabelWithMonthsDAO;
        this.interestAffinityLabelDAO = interestAffinityLabelDAO;
        this.genderAttributeDAO = genderAttributeDAO;
        this.integerAttributeDAO = integerAttributeDAO;
        this.stringAttributeDAO = stringAttributeDAO;
    }

    @Override
    public void run(String... args) throws Exception {
        var cooperatorCount = StreamSupport.stream(
                cooperatorDAO.findAll().spliterator(),
                false
            )
            .count();

        if (cooperatorCount <= 0) {
            StringAttribute userName = new StringAttribute(0L, "anthony2", Visibility.PUBLIC);
            stringAttributeDAO.save(userName);
            StringAttribute fullName = new StringAttribute(0L, "Anthony Miller", Visibility.PUBLIC);
            stringAttributeDAO.save(fullName);
            StringAttribute emailAddress = new StringAttribute(0L, "anthony2@gmail.com", Visibility.GROUPS_ONLY);
            stringAttributeDAO.save(emailAddress);
            IntegerAttribute age = new IntegerAttribute(0L, 35, Visibility.PRIVATE);
            integerAttributeDAO.save(age);
            GenderAttribute gender = new GenderAttribute(0L, Gender.MALE, Visibility.PUBLIC);
            genderAttributeDAO.save(gender);
            AffinityLabel strength = new AffinityLabel(0L, "js", "javascript");
            affinityLabelDAO.save(strength);
            InterestAffinityLabel interested = new InterestAffinityLabel(0L, "java", "java", InterestPriority.Primary);
            interestAffinityLabelDAO.save(interested);
            AffinityLabel improveIn = new AffinityLabel(0L, "react", "React");
            affinityLabelDAO.save(improveIn);
            AffinityLabel learnFromScratch = new AffinityLabel(0L, "docker", "Docker");
            affinityLabelDAO.save(learnFromScratch);
            AffinityLabelWithMonths learnt = new AffinityLabelWithMonths(0L, "react", "React", 3);
            affinityLabelWithMonthsDAO.save(learnt);

            var userAnthony = new CooperatorBuilder()
                .setUserName(userName)
                .setFullName(fullName)
                .setEmailAddress(emailAddress)
                .setAge(age)
                .setGender(gender)
                .addStrength(strength)
                .addInterested(interested)
                .addImproveIn(improveIn)
                .addLearnFromScratch(learnFromScratch)
                .addLearnt(learnt)
                .build();
            cooperatorDAO.save(userAnthony);
        }
    }
}
