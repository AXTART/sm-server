package com.secretmessage.smserver.Database;

import com.secretmessage.smserver.Model.User;

import java.util.ArrayList;

public class SmDatabaseTestImpl extends SmDatabase {

    private final ArrayList<User> users = new ArrayList<>();

    @Override
    public boolean createUser(User user) {
        users.add(user);
        return true;
    }
}
