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
        var userAnthony = new UserBuilder()
            .setId(1)
            .setUserName(new UserAttribute<>("anthony2", Visibility.PUBLIC))
            .setFullName(new UserAttribute<>("Anthony Miller", Visibility.PUBLIC))
            .setEmailAddress(new UserAttribute<>("anthony2@gmail.com", Visibility.GROUPS_ONLY))
            .setAge(new UserAttribute<>(35, Visibility.PRIVATE))
            .setGender(new UserAttribute<>(Gender.MALE, Visibility.PUBLIC))
            .addStrength(new AffinityLabel(1, "js", "javascript"))
            .addInterested(new AffinityLabelWithScale(2, "java", "java", 8))
            .build();
        var userRoster = new LinkedList<User>();
        userRoster.add(userAnthony);

        return new DummyUserDao(userRoster);
    }
}
