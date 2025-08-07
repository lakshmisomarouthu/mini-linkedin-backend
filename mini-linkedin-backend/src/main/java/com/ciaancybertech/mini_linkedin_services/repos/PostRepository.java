package com.ciaancybertech.mini_linkedin_services.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciaancybertech.mini_linkedin_services.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
	
	List<Post> findByUserId(Long userId);

}
