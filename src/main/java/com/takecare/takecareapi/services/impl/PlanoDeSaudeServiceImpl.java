package com.takecare.takecareapi.services.impl;

import com.takecare.takecareapi.api.dto.BuscarPlanoDeSaudeResponseDTO;
import com.takecare.takecareapi.api.dto.InsertPlanoDeSaudeDTO;
import com.takecare.takecareapi.api.dto.PlanoDeSaudeResponseDTO;
import com.takecare.takecareapi.entities.PlanoSaude;
import com.takecare.takecareapi.repository.PlanoDeSaudeRepository;
import com.takecare.takecareapi.services.PlanoDeSaudeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanoDeSaudeServiceImpl implements PlanoDeSaudeService {

    @Autowired
    private PlanoDeSaudeRepository planoRepository;

    @Override
    public PlanoDeSaudeResponseDTO insertPlanoDeSaude(InsertPlanoDeSaudeDTO request) {
        String nome = request.getNome();
        String categoria = request.getCategoria();

        PlanoDeSaudeResponseDTO response = new PlanoDeSaudeResponseDTO();

        PlanoSaude plano = new PlanoSaude();

        plano.setNomePlano(nome);
        plano.setCategoria(categoria);

        try {
            planoRepository.save(plano);
            response.setMessage("Plano Cadastrado com sucesso");
        } catch (Exception e) {
            response.setMessage("Não foi possível executar essa operação");
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public BuscarPlanoDeSaudeResponseDTO findPlanoById(int id) {
        BuscarPlanoDeSaudeResponseDTO response = new BuscarPlanoDeSaudeResponseDTO();

        try {
            PlanoSaude plano = planoRepository.findById(id);

            response.setPlano(plano);
            response.setMessage("OK");
            
            if(response.getPlano() == null) {
                response.setMessage("Usuário não encontrado"); 
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
    
}