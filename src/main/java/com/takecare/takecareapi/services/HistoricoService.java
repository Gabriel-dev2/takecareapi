package com.takecare.takecareapi.services;

import java.util.List;

import com.takecare.takecareapi.api.dto.HistoricoResponseDTO;

public interface HistoricoService {
    
    List<HistoricoResponseDTO> recuperarHistorico(Integer idPaciente);
}
