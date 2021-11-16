package com.secretmessage.smserver.database;

import com.secretmessage.smserver.Constants;
import com.secretmessage.smserver.model.User;

import java.util.ArrayList;

public class SmDatabaseTestImpl extends SmDatabase {

    private final ArrayList<User> users = new ArrayList<>();

    @Override
    public boolean createUser(User user) {
        if (containsUser(user.getUsername())) return false;
        users.add(user);
        Constants.LOGGER.info("New user created: \n" + user.userDescriptionString());
        return true;
    }

    private boolean containsUser(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) return true;
        }
        return false;
    }

    public User getUser(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) return u;
        }
        return null;
    }
}
