package com.ou_solutions.users_service.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRegisterRequest {
	
	private String firstName;
	private String lastName;
	private String password;
	private String email;

}
