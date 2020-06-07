package com.takecare.takecareapi.api.dto;


import lombok.Data;

@Data
public class LoginResponseDTO {
    
    private String cpf;
    private String message;
}