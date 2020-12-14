package com.takecare.takecareapi.services.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import com.takecare.takecareapi.api.dto.EmergenciaResponseDTO;
import com.takecare.takecareapi.entities.Ambulancia;
import com.takecare.takecareapi.entities.Chamado;
import com.takecare.takecareapi.entities.Historico;
import com.takecare.takecareapi.entities.Hospital;
import com.takecare.takecareapi.repository.EmergenciaRepository;
import com.takecare.takecareapi.repository.HistoricoRepository;
import com.takecare.takecareapi.services.ChamadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChamadoServiceImpl implements ChamadoService {

    EmergenciaRepository repository;
    HistoricoRepository historicoRepository;

    @Autowired
    public ChamadoServiceImpl(EmergenciaRepository em, HistoricoRepository hs) {
        this.repository = em;
        this.historicoRepository = hs;
    }

    @Override
    public EmergenciaResponseDTO chamarEmergencia(Integer idPaciente) {
        EmergenciaResponseDTO response = new EmergenciaResponseDTO();
        Chamado chamado = new Chamado();
        Historico historico = new Historico();
        // Ambulancia amb = new Ambulancia();
        // Hospital hospital = new Hospital();
        ZoneId timeZone = ZoneId.of("America/Recife");
        LocalDateTime dataChamado = LocalDateTime.now().atZone(timeZone).toLocalDateTime();

        chamado.setIdPaciente(idPaciente);
        chamado.setDataHora(dataChamado);
        chamado.setStatus("Solicitado");
        chamado.setDoencas("NA");
        chamado.setIdAmbulancia(2);
        chamado.setIdHospital(1);

        this.repository.saveAndFlush(chamado);

        List<Chamado> calls = repository.findAll();

        for (Chamado call : calls) {
            if (call.getDataHora() == dataChamado) {
                chamado.setId_chamado(call.getId_chamado());
            }
        }

        historico.setIdPaciente(idPaciente);
        historico.setDataHora(dataChamado);
        historico.setIdChamado(chamado.getId_chamado());
        historico.setNomeHospital("Hospital Exemplo");
        historico.setNomePlano("Sulamerica");
        historico.setNomeSintoma("NA");
        historico.setPlacaAmbulancia("NA");
        historico.setIdlogatendente(2);
        this.historicoRepository.insertValues(historico.getDataHora(), historico.getPlacaAmbulancia(), historico.getNomeSintoma(), historico.getNomeHospital(), historico.getNomePlano(), historico.getIdlogatendente(), historico.getIdPaciente(), historico.getIdChamado());
        response.setMessage("Emergencia solicitada com sucesso por favor aguarde no local");

        return response;
    }
    
}
