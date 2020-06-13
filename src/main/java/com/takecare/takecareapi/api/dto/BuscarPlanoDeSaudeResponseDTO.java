package com.takecare.takecareapi.api.dto;

import com.takecare.takecareapi.entities.PlanoSaude;

import lombok.Data;

@Data
public class BuscarPlanoDeSaudeResponseDTO {
    private String message;
    private PlanoSaude plano;
}