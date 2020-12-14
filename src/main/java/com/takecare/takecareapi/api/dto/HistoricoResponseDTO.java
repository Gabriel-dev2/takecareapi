package com.takecare.takecareapi.api.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class HistoricoResponseDTO {
    private LocalDateTime datahora;
    private String placaAmbulancia;
    private Integer idChamado;
    private String nomeSintoma;
    private String nomeDoPlano;
    private Integer idlogatendente;
    private Integer idPaciente;
    private String message;
}
