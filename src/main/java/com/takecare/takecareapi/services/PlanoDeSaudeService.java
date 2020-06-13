package com.takecare.takecareapi.services;

import com.takecare.takecareapi.api.dto.BuscarPlanoDeSaudeResponseDTO;
import com.takecare.takecareapi.api.dto.InsertPlanoDeSaudeDTO;
import com.takecare.takecareapi.api.dto.PlanoDeSaudeResponseDTO;

public interface PlanoDeSaudeService {
    
    PlanoDeSaudeResponseDTO insertPlanoDeSaude(InsertPlanoDeSaudeDTO request);

    BuscarPlanoDeSaudeResponseDTO findPlanoById(int id);

}