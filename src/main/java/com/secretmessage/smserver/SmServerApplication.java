package com.secretmessage.smserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.UUID;
import java.util.Vector;


@SpringBootApplication
@RestController
public class SmServerApplication {
	Vector<User> users = new Vector<User>();
	public static void main(String[] args) {
		SpringApplication.run(SmServerApplication.class, args);
	}

	@GetMapping("/register")
	public ResponseEntity<String> register(
			@RequestHeader("login") String login,
			@RequestHeader("pass") String pass,
			@RequestHeader("language") String language_res
			) {

		users.add(new User(
			users.size(),
			Instant.now().getEpochSecond(),
			login,
			language_res,
			UserType.type.USER,
			UUID.randomUUID()
			)
		);
		print(users.get(users.size()-1).username);
		return new ResponseEntity<String>(GetHash.token(users.get(users.size()-1).username, users.get(users.size()-1).id, users.get(users.size()-1).uuid.toString()), HttpStatus.OK);
	}

	private void print(String out) {
		System.out.println(out);
	}


}
















