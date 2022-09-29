package com.codecool.elproyectegrande.persistance;

import com.codecool.elproyectegrande.model.User;

import java.util.List;

public interface UserDao {
    User findById(long id);
    void update(User updatedUser);
    void deleteById(long id);
    List<User> getAllUser();
}
