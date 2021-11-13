package com.secretmessage.smserver;

import java.util.UUID;
import java.util.Vector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.secretmessage.smserver.UserType.type.Developer;


@SpringBootApplication
@RestController
public class SmServerApplication {
	Vector<User> users = new Vector<User>();
	public static void main(String[] args) {
		SpringApplication.run(SmServerApplication.class, args);
	}

	@GetMapping("/register")
	public ResponseEntity<String> register(@RequestHeader("login") String login, @RequestHeader("pass") String pass) {
		users.add(new User(

		))
		return String.format(GetHash.token());
	}


}
















