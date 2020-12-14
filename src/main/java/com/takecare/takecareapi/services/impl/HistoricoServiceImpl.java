package com.takecare.takecareapi.services.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.takecare.takecareapi.api.dto.HistoricoResponseDTO;
import com.takecare.takecareapi.entities.Historico;
import com.takecare.takecareapi.repository.HistoricoRepository;
import com.takecare.takecareapi.services.HistoricoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoricoServiceImpl implements HistoricoService {

    HistoricoRepository repository;

    @Autowired
    public HistoricoServiceImpl(HistoricoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<HistoricoResponseDTO> recuperarHistorico(Integer idPaciente) {
        HistoricoResponseDTO historicoResponse = new HistoricoResponseDTO();
        List<HistoricoResponseDTO> response = new ArrayList<HistoricoResponseDTO>();
        List<Historico> hist = repository.findByIdPaciente(idPaciente);
        ZoneId timeZone = ZoneId.of("America/Recife");
       
        for (Historico h : hist) {
            if (h.getIdPaciente() == idPaciente) {
                LocalDateTime dataLocal = h.getDataHora().atZone(timeZone).toLocalDateTime().minusHours(3);
                historicoResponse.setIdChamado(h.getIdChamado());
                historicoResponse.setDatahora(dataLocal);
                historicoResponse.setIdPaciente(h.getIdPaciente());
                response.add(historicoResponse);
            } else {
                    historicoResponse.setMessage("Não há histórico disponível no momento para este paciente");
                    response.add(historicoResponse);
                }
        }
        

        return response;
    }
    
}
