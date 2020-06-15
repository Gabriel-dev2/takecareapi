package com.takecare.takecareapi.api.dto;

import lombok.Data;

@Data
public class BuscarPlanoDeSaudeResponseDTO {
    private String message;
    private int id;
    private String nomePlano;
    private String categoria;
}