package com.secretmessage.smserver.Model;

import java.time.Instant;
import java.util.UUID;

public class User {
    private final long createdAt;
    private String username;
    private String password;
    private UserType userType;
    private UUID uuid;

    public User(String username, String password, UUID uuid) {
        this.createdAt = Instant.now().getEpochSecond();
        this.username = username;
        this.password = password;
        this.userType = UserType.USER;
        this.uuid = uuid;
    }
    public User(long createdAt, String username, String password, UserType userType, UUID uuid){
        this.createdAt = createdAt;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.uuid = uuid;

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

    public UserType getUser_type() {
        return userType;
    }

    public UUID getUuid() {
        return uuid;
    }
}
