package com.takecare.takecareapi.api.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.takecare.takecareapi.entities.Paciente;

import lombok.Data;

@Data
public class SubmitCreateRequestDTO {
    @NotNull
    @Valid
    private Paciente paciente;
}