package com.ciaancybertech.mini_linkedin_services.services;

import org.springframework.stereotype.Service;

import com.ciaancybertech.mini_linkedin_services.entities.User;
import com.ciaancybertech.mini_linkedin_services.repos.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	private final UserRepository userRepository;
	
	
	public String saveUser(User user) {
		
		try {
			userRepository.save(user);
			return "User added Successfully";
		}
		 catch(Exception EX){
			 
			 System.out.println(EX.getMessage());
			 return "Error adding user details";
			 
		 }
		
	}

}
