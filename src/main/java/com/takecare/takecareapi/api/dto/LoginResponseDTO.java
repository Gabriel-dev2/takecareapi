package com.takecare.takecareapi.api.dto;

import com.takecare.takecareapi.entities.Login;

import lombok.Data;

@Data
public class LoginResponseDTO {
    
    private Login login;
    private String message;
}