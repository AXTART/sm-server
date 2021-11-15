package com.secretmessage.smserver.Database;

import com.secretmessage.smserver.Model.User;

public abstract class SmDatabase {
    public abstract boolean createUser(User user);
}
