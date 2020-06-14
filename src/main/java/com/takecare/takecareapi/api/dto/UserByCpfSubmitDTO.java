package com.takecare.takecareapi.api.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserByCpfSubmitDTO {
    @NotNull
    private String cpf;
}