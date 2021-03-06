package com.secretmessage.smserver.model;

import com.secretmessage.smserver.util.GetHash;

import java.time.Instant;
import java.util.UUID;

public class User {
    private final long createdAt;
    private String username;
    private String password;
    private UserType userType;
    private UUID uuid;
    private String salt;
    private String email;

    public User(String username, String password, UUID uuid, String email) {
        this.salt = GetHash.randomHex(20);
        this.createdAt = Instant.now().getEpochSecond();
        this.username = username;
        this.password = sha256(password);
        this.userType = UserType.USER;
        this.uuid = uuid;
        this.email = email;
    }
    public User(long createdAt, String username, String password, UserType userType, UUID uuid, String email){
        this.salt = GetHash.randomHex(20);
        this.createdAt = createdAt;
        this.username = username;
        this.password = sha256(password);
        this.userType = userType;
        this.uuid = uuid;
        this.email = email;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserType getUserType() {
        return userType;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getEmail() {
        return email;
    }

    public String sha256(String text) {
        return GetHash.sha256(text + this.salt);
    }
    public String getToken() {
        return GetHash.token(this);
    }

    public boolean verify(String password) {
        return (getPassword().equals(sha256(password)));
    }

    public String userDescriptionString() {
        return "Username: " + getUsername() +
                "\nEmail: " + getEmail() +
                "\nUUID: " + getUuid() +
                "\nType: " + getUserType() +
                "\nCreation Timestamp: " + getCreatedAt();
    }
}
