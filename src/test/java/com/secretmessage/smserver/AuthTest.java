package com.secretmessage.smserver;

import com.secretmessage.smserver.database.SmDatabaseTestImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void checkRegisterAndLogin() throws Exception {
        Constants.DATABASE = new SmDatabaseTestImpl();

        // Check register
        mvc.perform(post("/auth/register")
                .header("login", "hello")
                .header("pass", "world")
                .header("email", "helloworld@secmsg.me")
        )
                .andExpect(status().isCreated());

        // Check login correct
        mvc.perform(post("/auth/login")
                .header("email", "helloworld@secmsg.me")
                .header("pass", "world")
        )
                .andExpect(status().isOk());

        // Check login incorrect email
        mvc.perform(post("/auth/login")
                        .header("email", "worldhello@secmsg.me")
                        .header("pass", "hello")
                )
                .andExpect(status().isUnauthorized());

        // Check login incorrect pass
        mvc.perform(post("/auth/login")
                        .header("email", "helloworld@secmsg.me")
                        .header("pass", "hello")
                )
                .andExpect(status().isUnauthorized());
    }

}
