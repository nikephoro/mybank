package org.idev.mybank.service;

import org.idev.mybank.model.User;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserService {

    private final List<User> users = new CopyOnWriteArrayList<>();

    public User createUser(String id, String name) {
        User user = new User(id, name);
        users.add(user);
        return user;

    }

    public boolean containsUser(String id) {
        return users.stream()
                .anyMatch(u -> u.getId().equals(id));
    }
    public List<User> findAllUsers() {
        return users;
    }
}
