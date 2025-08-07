package com.ciaancybertech.mini_linkedin_services.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.naming.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciaancybertech.mini_linkedin_services.entities.User;
import com.ciaancybertech.mini_linkedin_services.repos.UserRepository;
import com.ciaancybertech.mini_linkedin_services.req.AuthRequest;
import com.ciaancybertech.mini_linkedin_services.security.JwtUtil;
import com.ciaancybertech.mini_linkedin_services.services.AuthService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class AuthController {
	
	private final AuthService authservice;
	
	private final AuthenticationManager authenticationManager;
    
    private final JwtUtil jwtUtil;
    
    private final UserRepository userRepository;
   
    private final PasswordEncoder encoder;
	
	@PostMapping("/register")
	public String register(@RequestBody User user){ 
		
		log.info("User RequestBody:{}",user);
		
		user.setPassword(encoder.encode(user.getPassword()));
		log.info("Encoded:{}",user.getPassword());
        userRepository.save(user);
        return "User registered successfully";
		   
		
	}
	
	@PostMapping("/login")
    public String login(@RequestBody AuthRequest request) throws Exception {
		
		log.info("Request:{}",request);
        authenticationManager.authenticate(
		        new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        String jwtToken= jwtUtil.generateToken(request.getEmail());
        log.info("jwtToken:{}",jwtToken);
        return jwtToken;
    }
	
	
	

}
