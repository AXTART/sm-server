package com.secretmessage.smserver.controllers;

import com.secretmessage.smserver.Constants;
import com.secretmessage.smserver.model.User;
import com.secretmessage.smserver.response.LoginResponse;
import com.secretmessage.smserver.response.Response;
import com.secretmessage.smserver.response.ResponseStatus;
import com.secretmessage.smserver.response.StatusResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping(value = "/register", produces = "application/json")
    public ResponseEntity<Response> register(
            @RequestHeader("login") String login,
            @RequestHeader("pass") String pass
    ) {
        // create user
        User user = new User(
                login,
                pass,
                UUID.randomUUID()
        );
        // add it to database and return a response
        if (Constants.DATABASE.createUser(user)) {
            return new ResponseEntity<>(new LoginResponse(ResponseStatus.SUCCESS, user.getUsername(), user.getToken()), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new StatusResponse(ResponseStatus.FAIL), HttpStatus.NOT_MODIFIED);
    }

    @PostMapping(value = "/login", produces = "application/json")
    public ResponseEntity<Response> login(
            @RequestHeader("login") String login,
            @RequestHeader("pass") String pass
    ) {
        // get user
       User u = Constants.DATABASE.getUser(login);
       if (u == null) return new ResponseEntity<>(new StatusResponse(ResponseStatus.FAIL), HttpStatus.BAD_REQUEST);

       // verify user
       if (u.verify(pass)) {
           return new ResponseEntity<>(
                   new LoginResponse(ResponseStatus.SUCCESS, u.getUsername(), u.getToken()),
                   HttpStatus.OK
           );
       } else {
           return new ResponseEntity<>(new StatusResponse(ResponseStatus.FAIL), HttpStatus.UNAUTHORIZED);
       }
    }

    // TODO: add login method and return some kind of token for a user
}
