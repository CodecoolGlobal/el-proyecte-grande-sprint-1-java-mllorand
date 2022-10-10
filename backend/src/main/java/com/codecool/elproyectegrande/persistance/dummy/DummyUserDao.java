package com.codecool.elproyectegrande.persistance.dummy;

import com.codecool.elproyectegrande.model.Cooperator;
import com.codecool.elproyectegrande.persistance.CooperatorDAO;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DummyUserDao implements CooperatorDAO {
    private final List<Cooperator> cooperatorStorage;

    public DummyUserDao(List<Cooperator> cooperatorStorage) {
        this.cooperatorStorage = cooperatorStorage;
    }

    private ListIterator<Cooperator> moveToUserById(long id) {
        var iterator = cooperatorStorage.listIterator();
        long currentId = iterator.next().getId();

        while(iterator.hasNext() && currentId != id) {
            currentId = iterator.next().getId();
        }

        if (currentId != id) {
            throw new NoSuchElementException();
        }

        return iterator;
    }

    @Override
    public Cooperator findById(long id) {
        return moveToUserById(id).previous();
    }

    @Override
    public void update(Cooperator updatedCooperator) {
        var iterator = moveToUserById(updatedCooperator.getId());
        iterator.set(updatedCooperator);
    }

    @Override
    public void deleteById(long id) {
        var iterator = moveToUserById(id);
        iterator.remove();
    }

    @Override
    public List<Cooperator> getAllUser() {
        return List.copyOf(cooperatorStorage);
    }
}
