package com.kiran.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiran.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
	//public Optional<User> fingUserByEmail(String email);
	public Optional<User> findByEmail(String email);
}
