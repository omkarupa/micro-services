package com.ou_solutions.users_service.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ou_solutions.users_service.controller.dto.UserRegisterRequest;
import com.ou_solutions.users_service.controller.exception.UserServiceException;
import com.ou_solutions.users_service.controller.model.User;
import com.ou_solutions.users_service.controller.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepo;
	
	public User createUser(UserRegisterRequest userRequest) 
	{
		User user = User.builder()
				.firstName(userRequest.getFirstName())
				.lastName(userRequest.getLastName())
				.email(userRequest.getEmail())
				.password(userRequest.getPassword())
				.build();
		
		try {
			return userRepo.save(user);	
		} catch (DataIntegrityViolationException e) {
			throw new UserServiceException("Emailid is already registered. Please try with another emailid");
		}
		
	}
	
	public List<User> findAllUsers()
	{
		return userRepo.findAll();
	}

}
