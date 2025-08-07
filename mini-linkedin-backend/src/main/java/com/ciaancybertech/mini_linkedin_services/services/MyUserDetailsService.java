package com.ciaancybertech.mini_linkedin_services.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ciaancybertech.mini_linkedin_services.entities.User;
import com.ciaancybertech.mini_linkedin_services.repos.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyUserDetailsService  implements UserDetailsService{


	    private final UserRepository userRepository;

	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	    	
	    	log.info("Attempting login for email: {}", email);
	        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Not found"));
	        return org.springframework.security.core.userdetails.User
	                .withUsername(user.getEmail())
	                .password(user.getPassword())
	                .authorities("USER")
	                .build();
	    }
}
