package com.takecare.takecareapi.api.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SubmitEditUserRequestDTO {
    
    @NotNull
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String cpf;

    @NotNull
    private String senha;

    @NotNull
    private String endereco;

    @NotNull
    private int numeroCasa;

    @NotNull
    private int idPlano;

    @NotNull
    private String email;
}