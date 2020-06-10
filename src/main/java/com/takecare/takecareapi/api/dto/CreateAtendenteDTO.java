package com.takecare.takecareapi.api.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CreateAtendenteDTO {

    @NotNull
    private String matricula;

    @NotNull
    private String nome;

    @NotNull
    private String senha;
}