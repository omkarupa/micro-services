package com.ou_solutions.users_service.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ou_solutions.users_service.controller.dto.UserRegisterRequest;
import com.ou_solutions.users_service.controller.dto.UserResponse;
import com.ou_solutions.users_service.service.UserService;
import com.ou_solutions.users_service.util.UserUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRestController {
	
	Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
	@Value("${server.port}")
	String serverPort;
	
	private final UserService userService;

	@GetMapping("/status/check")
	public String getStatusCheck()
	{
		return "User Service is up and running at Server Port " + serverPort;
	}
	
	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody UserRegisterRequest userRequest)
	{
		logger.info(userRequest.toString());
		
		
		if(userService.createUser(userRequest) != null)
		{
			return ResponseEntity.ok("User is created sucessfully for "+ userRequest.getEmail());
		}
		
		return (ResponseEntity<String>) ResponseEntity.badRequest();
	}
	
	@GetMapping
	public List<UserResponse> getAllUsers()
	{
		return userService.findAllUsers().stream().map(user -> UserUtil.mapUserResponse(user)).collect(Collectors.toList());
	}
	
	
}
