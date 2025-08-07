package com.ciaancybertech.mini_linkedin_services.controllers;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ciaancybertech.mini_linkedin_services.entities.User;
import com.ciaancybertech.mini_linkedin_services.repos.UserRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@CrossOrigin
public class ProfileController {

	private final UserRepository userRepository;

	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id){
	    return userRepository.findById(id).orElse(null);
	}
}



