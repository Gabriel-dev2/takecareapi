package com.takecare.takecareapi.api.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EmergenciaInputDTO {
    private String doencas;

    @NotNull
    private LocalDateTime dataehora;
    private String status;
    private Integer idAmbulancia;
    private Integer idPaciente;
    private Integer idHospital;
}
