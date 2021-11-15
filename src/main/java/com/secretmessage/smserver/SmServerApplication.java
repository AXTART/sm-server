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
	Vector<User> users;
	public static void main(String[] args) {
		SpringApplication.run(SmServerApplication.class, args);
	}

	@GetMapping("/register")
	public ResponseEntity<String> register(
			@RequestHeader("login") String login,
			@RequestHeader("pass") String pass,
			@RequestHeader("language") String language_res
			) {
		User current_user = new User(
				users.size(),
				Instant.now().getEpochSecond(),
				login,
				language_res,
				UserType.type.USER,
				UUID.randomUUID()
		);
		users.add(current_user);
		print(users.get(users.size()-1).username);
		return new ResponseEntity<String>(
				GetHash.token(
						current_user
				),
				HttpStatus.OK);
	}

	private void print(String out) {
		System.out.println(out);
	}


}
















