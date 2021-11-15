package com.secretmessage.smserver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.util.UUID;
import java.util.Vector;

public class RegisterRoute {

    public static ResponseEntity<String> run(String login, String password, String language_res){
        Vector<User> users = new ReadUserbase();
        User current_user = new User(
                users.size(),
                Instant.now().getEpochSecond(),
                login,
                language_res,
                UserType.type.USER,
                UUID.randomUUID()
        );
        users.add(current_user);
        System.out.println(users.get(users.size()-1).username);
        return new ResponseEntity<String> (
                GetHash.token(current_user),
                HttpStatus.OK);
    }
}
