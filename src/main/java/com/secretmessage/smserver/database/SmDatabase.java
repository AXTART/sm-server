package com.secretmessage.smserver.database;

import com.secretmessage.smserver.model.User;

public abstract class SmDatabase {
    public abstract boolean createUser(User user);
    public abstract User getUser(String email);
}
