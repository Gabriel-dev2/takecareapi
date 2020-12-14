package com.takecare.takecareapi.api.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class HistoricoDTO {
    @NotNull
    private Integer idPaciente;
}
