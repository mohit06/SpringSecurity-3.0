package com.webClient.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class HelloWorldApp3Application {

	@Autowired

	PasswordEncoder pe;

	public static void main(String[] args) {

		SpringApplication.run(HelloWorldApp3Application.class, args);

	}

}
