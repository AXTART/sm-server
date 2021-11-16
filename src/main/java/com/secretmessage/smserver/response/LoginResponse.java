package com.secretmessage.smserver.response;

public class LoginResponse implements Response {

    public ResponseStatus status;
    public String username;
    public String token;

    public LoginResponse(ResponseStatus status, String username, String token) {
        this.status = status;
        this.username = username;
        this.token = token;
    }

}
