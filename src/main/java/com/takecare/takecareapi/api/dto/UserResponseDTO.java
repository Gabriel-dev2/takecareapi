package com.takecare.takecareapi.api.dto;

import com.takecare.takecareapi.entities.Paciente;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Paciente paciente;
}