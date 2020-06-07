package com.takecare.takecareapi.api.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SintomasSubmitCreateDTO {
    @NotNull
    private int id;
    @NotNull
    private String nome;
}