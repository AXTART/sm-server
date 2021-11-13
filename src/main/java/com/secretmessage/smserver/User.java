package com.secretmessage.smserver;

public class User {
    long id;
    long createdAt;
    int discriminator;
    String username;
    String language;
    UserType.type user_type;
    public User(int id, long createdAt, int discriminator, String username, String language, UserType.type user_type){
        this.id = id;
        this.createdAt = createdAt;
        this.discriminator = discriminator;
        this.username = username;
        this.language = language;
        this.user_type = user_type;

    }

}
