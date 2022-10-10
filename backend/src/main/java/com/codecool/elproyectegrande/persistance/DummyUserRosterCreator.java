package com.codecool.elproyectegrande.persistance;

import com.codecool.elproyectegrande.model.*;
import com.codecool.elproyectegrande.persistance.dummy.DummyUserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;

@Configuration
public class DummyUserRosterCreator {
    @Bean
    public UserDao createUserRoster() {
        var userAnthony = new CooperatorBuilder()
            .setId(1)
            .setUserName(new CooperatorAttribute<>("anthony2", Visibility.PUBLIC))
            .setFullName(new CooperatorAttribute<>("Anthony Miller", Visibility.PUBLIC))
            .setEmailAddress(new CooperatorAttribute<>("anthony2@gmail.com", Visibility.GROUPS_ONLY))
            .setAge(new CooperatorAttribute<>(35, Visibility.PRIVATE))
            .setGender(new CooperatorAttribute<>(Gender.MALE, Visibility.PUBLIC))
            .addStrength(new AffinityLabel(1, "js", "javascript"))
            .addInterested(new AffinityLabelWithScale(2, "java", "java", 8))
            .addImproveIn(new AffinityLabel(3, "react", "React"))
            .addLearnFromScratch(new AffinityLabel(4, "docker", "Docker"))
            .build();
        var userRoster = new LinkedList<Cooperator>();
        userRoster.add(userAnthony);

        return new DummyUserDao(userRoster);
    }
}