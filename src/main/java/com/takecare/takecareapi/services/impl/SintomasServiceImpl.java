package com.takecare.takecareapi.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.takecare.takecareapi.api.dto.SintomasResponseDTO;
import com.takecare.takecareapi.api.dto.SintomasSubmitCreateDTO;
import com.takecare.takecareapi.api.dto.SintomasSubmitResponseDTO;
import com.takecare.takecareapi.entities.Sintomas;
import com.takecare.takecareapi.repository.SintomasRepository;
import com.takecare.takecareapi.services.SintomasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SintomasServiceImpl implements SintomasService {

    @Autowired
    SintomasRepository sintomasRepo;

    @Override
    public SintomasSubmitResponseDTO insertSintoma(SintomasSubmitCreateDTO request) {
        int id = request.getId();
        String nome = request.getNome();
        SintomasSubmitResponseDTO sintomasSubmitResponseDTO = new SintomasSubmitResponseDTO();
        try {
           Sintomas s = new Sintomas();
           s.setIdSintoma(id);
           s.setNome(nome);
           sintomasRepo.save(s);
           sintomasSubmitResponseDTO.setMessage("Sintoma inserido com sucesso");
        } catch(Exception e) {
            sintomasSubmitResponseDTO.setMessage("Ocorreu um problema ao inserir seu sintoma");
        }
        return sintomasSubmitResponseDTO;
    }

    @Override
    public SintomasResponseDTO selectSintoma(int id) {
        Sintomas s = new Sintomas();
        SintomasResponseDTO sintomasResponseDTO = new SintomasResponseDTO();

        s = sintomasRepo.findById(id);
        sintomasResponseDTO.setSintoma(s);
        return sintomasResponseDTO;
    }

    @Override
    public List<SintomasResponseDTO> listAllSintomas() {
        List<Sintomas> s = new ArrayList<>();
        SintomasResponseDTO sintomasResponseDTO = new SintomasResponseDTO();
        List<SintomasResponseDTO> sintomasResponseDTOs = new ArrayList<>();

        s = sintomasRepo.findAll();
        for (Sintomas sintomas : s) {
            sintomasResponseDTO.setSintoma(sintomas);
            sintomasResponseDTOs.add(sintomasResponseDTO);
        }
        return sintomasResponseDTOs;
    }
    
}