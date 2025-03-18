package com.ec2.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ec2.demo.pojo.User;

@RestController
public class UserController {
	@PostMapping("/register")
	public String register(@RequestBody User userRegistrationDto) {
		return "User registered successfully: " + userRegistrationDto.getName();
	}
}
