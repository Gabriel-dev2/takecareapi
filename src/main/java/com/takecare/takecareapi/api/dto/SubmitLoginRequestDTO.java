package com.takecare.takecareapi.api.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SubmitLoginRequestDTO {
    
    @NotNull
    private String cpf;

    @NotNull
    private String senha;
}