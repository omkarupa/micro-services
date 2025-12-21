package com.ou_solutions.users_service.util;

import com.ou_solutions.users_service.controller.dto.UserResponse;
import com.ou_solutions.users_service.controller.model.User;

public class UserUtil {

	public static UserResponse mapUserResponse(User user) {
	
		return UserResponse.builder()
				.email(user.getEmail())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.build();
		
	}

}
