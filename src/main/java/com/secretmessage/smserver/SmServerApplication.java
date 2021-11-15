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

	public static void main(String[] args) {
		SpringApplication.run(SmServerApplication.class, args);
	}

	@GetMapping("/register")
	public ResponseEntity<String> register(
			@RequestHeader("login") String login,
			@RequestHeader("pass") String pass,
			@RequestHeader("language") String language_res
			) {
				ResponseEntity<String> resp = RegisterRoute.run(login, pass, language_res);
				return resp;
			}

	private void print(String out) {
		System.out.println(out);
	}


}
















