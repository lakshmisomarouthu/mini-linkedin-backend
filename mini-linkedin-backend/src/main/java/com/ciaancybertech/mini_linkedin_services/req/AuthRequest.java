package com.ciaancybertech.mini_linkedin_services.req;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
