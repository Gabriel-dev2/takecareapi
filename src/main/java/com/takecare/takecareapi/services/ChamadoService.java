package com.takecare.takecareapi.services;

import com.takecare.takecareapi.api.dto.EmergenciaResponseDTO;

public interface ChamadoService {
    
    EmergenciaResponseDTO chamarEmergencia(Integer idPaciente);
}
