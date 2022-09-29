package com.codecool.elproyectegrande.persistance.dummy;

import com.codecool.elproyectegrande.model.User;
import com.codecool.elproyectegrande.persistance.UserDao;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DummyUserDao implements UserDao {
    private final List<User> userStorage;

    public DummyUserDao(List<User> userStorage) {
        this.userStorage = userStorage;
    }

    private ListIterator<User> moveToUserById(long id) {
        var iterator = userStorage.listIterator();
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
    public User findById(long id) {
        return moveToUserById(id).previous();
    }

    @Override
    public void update(User updatedUser) {
        var iterator = moveToUserById(updatedUser.getId());
        iterator.set(updatedUser);
    }

    @Override
    public void deleteById(long id) {
        var iterator = moveToUserById(id);
        iterator.remove();
    }

    @Override
    public List<User> getAllUser() {
        return List.copyOf(userStorage);
    }
}
