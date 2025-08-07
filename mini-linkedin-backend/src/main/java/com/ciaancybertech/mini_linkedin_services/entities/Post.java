package com.ciaancybertech.mini_linkedin_services.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Post {
 @Id @GeneratedValue
 private Long id;

 private String content;
 private LocalDateTime createdAt;

 @ManyToOne
 private User user;
}


