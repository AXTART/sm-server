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

}
















