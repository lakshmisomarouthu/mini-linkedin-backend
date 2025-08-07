package com.ciaancybertech.mini_linkedin_services.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ciaancybertech.mini_linkedin_services.entities.Post;
import com.ciaancybertech.mini_linkedin_services.entities.User;
import com.ciaancybertech.mini_linkedin_services.repos.PostRepository;
import com.ciaancybertech.mini_linkedin_services.repos.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
public class PostController {
	
	private final PostRepository postRepository;
	private final UserRepository userRepository;
	
	
	 @PostMapping("/posts")
	    public Post addPost(@RequestBody Post post,
	                        @AuthenticationPrincipal UserDetails userDetails) {
	        log.info("Add post request received: {}", post);

	        User user = userRepository.findByEmail(userDetails.getUsername()).get();
	        post.setUser(user);
	        post.setCreatedAt(LocalDateTime.now());
	        Post saved = postRepository.save(post);

	        log.info("Post created with id {} for user {}", saved.getId(), user.getEmail());
	        return saved;
	    }

	    //  Get ALL posts
	    @GetMapping("/posts")
	    public List<Post> getAllPosts(){
	        log.info("Fetching all posts");
	        return postRepository.findAll();
	    }

	    //  Get posts of CURRENT logged-in user
	    @GetMapping("/posts/my")
	    public List<Post> getMyPosts(@AuthenticationPrincipal UserDetails userDetails) {
	        log.info("Fetching posts for current user {}", userDetails.getUsername());
	        User user = userRepository.findByEmail(userDetails.getUsername()).get();
	        return postRepository.findByUserId(user.getId());
	    }

	    //  GET posts of any user by id
	    @GetMapping("/posts/user/{userId}")
	    public List<Post> getPostsByUser(@PathVariable Long userId){
	        log.info("Fetching posts for userId {}", userId);
	        return postRepository.findByUserId(userId);
	    }
	


}
