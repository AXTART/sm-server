package com.secretmessage.smserver;

public class User {
    long id;
    long createdAt;
    int discriminator;
    String username;
    String language;
    Boolean isDeveloper;
    UserType user_type;

}
