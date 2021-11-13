package com.secretmessage.smserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
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
			@RequestHeader("discriminator") String discriminator_res,
			@RequestHeader("language") String language_res
			) {
		users.add(new User(
			users.size()+1,
			Instant.now().getEpochSecond(),
			users.size()+1,
			login,
			language_res,
			UserType.type.USER
			)
		);
		print(String.valueOf(users.get(users.size())));
		return new ResponseEntity<String>(users.get(0).username, HttpStatus.OK);
	}

	private void print(String out) {
		System.out.println(out);
	}


}
















