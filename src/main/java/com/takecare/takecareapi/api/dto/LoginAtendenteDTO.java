package com.takecare.takecareapi.api.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LoginAtendenteDTO {
    
    @NotNull
    private String matricula;
    
    @NotNull
    private String senha;
    
}