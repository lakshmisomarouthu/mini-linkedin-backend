package com.ciaancybertech.mini_linkedin_services.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciaancybertech.mini_linkedin_services.entities.User;

public interface UserRepository  extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String email);
}
