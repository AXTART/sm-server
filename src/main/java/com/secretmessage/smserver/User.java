package com.secretmessage.smserver;

import java.util.UUID;

public class User {
    long id;
    long createdAt;
    String username;
    String language;
    UserType.type user_type;
    UUID uuid;
    public User(int id, long createdAt, String username, String language, UserType.type user_type, UUID uuid){
        this.id = id;
        this.createdAt = createdAt;
        this.username = username;
        this.language = language;
        this.user_type = user_type;
        this.uuid = uuid;

    }

}
