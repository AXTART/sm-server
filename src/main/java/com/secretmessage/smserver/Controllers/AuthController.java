package com.secretmessage.smserver.Controllers;

import com.secretmessage.smserver.Constants;
import com.secretmessage.smserver.Model.User;
import com.secretmessage.smserver.Response.ResponseStatus;
import com.secretmessage.smserver.Response.StatusResponse;
import com.secretmessage.smserver.Util.GetHash;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping(value = "/register", produces = "application/json")
    public StatusResponse register(
            @RequestHeader("login") String login,
            @RequestHeader("pass") String pass
    ) {
        if (Constants.DATABASE.createUser(new User(
                login,
                pass,
                UUID.randomUUID()
        ))) {
            return new StatusResponse(ResponseStatus.SUCCESS);
        }
        return new StatusResponse(ResponseStatus.FAIL);
    }

    // TODO: add login method and return some kind of token for a user
}
