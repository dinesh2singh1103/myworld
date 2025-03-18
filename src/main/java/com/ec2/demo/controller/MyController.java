package com.ec2.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ec2.demo.pojo.User;

@RestController
public class MyController {
	@Autowired
	AuthenticationManagerBuilder authentication;

	@PostMapping("/users")
	public String createUser(@RequestBody User user) {
		return "User created: " + user.getName();
	}

	@GetMapping("/getusers")
	public String getUser() {
		return "User created: ";// + user.getName();
	}

	@GetMapping("/welcome")
	public String welcome(Authentication authentication) {

		String userName = authentication.getName();
		return "Spring Security In-memory Authentication Example - Welcome " + userName;
	}
}
