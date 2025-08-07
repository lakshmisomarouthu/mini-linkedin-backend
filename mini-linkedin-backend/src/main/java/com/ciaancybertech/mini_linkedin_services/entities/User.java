package com.ciaancybertech.mini_linkedin_services.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
 @Id @GeneratedValue
 private Long id;
 private String name;
 @Column(unique = true, nullable = false)
 private String email;
 
 private String password;
 private String bio;
}