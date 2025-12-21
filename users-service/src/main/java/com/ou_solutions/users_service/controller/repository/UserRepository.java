package com.ou_solutions.users_service.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ou_solutions.users_service.controller.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
