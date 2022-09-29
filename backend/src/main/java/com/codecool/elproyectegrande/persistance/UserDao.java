package com.codecool.elproyectegrande.persistance;

import com.codecool.elproyectegrande.model.Cooperator;

import java.util.List;

public interface UserDao {
    Cooperator findById(long id);
    void update(Cooperator updatedCooperator);
    void deleteById(long id);
    List<Cooperator> getAllUser();
}
