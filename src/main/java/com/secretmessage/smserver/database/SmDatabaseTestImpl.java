package com.secretmessage.smserver.database;

import com.secretmessage.smserver.Constants;
import com.secretmessage.smserver.model.User;

import java.util.ArrayList;

// THIS IMPLEMENTATION IS USED DURING UNIT TESTS

public class SmDatabaseTestImpl extends SmDatabase {

    private final ArrayList<User> users = new ArrayList<>();

    @Override
    public boolean createUser(User user) {
        if (containsUser(user.getEmail())) return false;
        users.add(user);
        Constants.LOGGER.info("New user created: \n" + user.userDescriptionString());
        return true;
    }

    private boolean containsUser(String email) {
        for (User u : users) {
            if (u.getEmail().equals(email)) return true;
        }
        return false;
    }

    public User getUser(String email) {
        for (User u : users) {
            if (u.getEmail().equals(email)) return u;
        }
        return null;
    }
}
