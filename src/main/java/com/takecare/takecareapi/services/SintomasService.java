package com.takecare.takecareapi.services;

import java.util.List;

import com.takecare.takecareapi.api.dto.SintomasResponseDTO;
import com.takecare.takecareapi.api.dto.SintomasSubmitCreateDTO;
import com.takecare.takecareapi.api.dto.SintomasSubmitResponseDTO;

public interface SintomasService {
    SintomasSubmitResponseDTO insertSintoma(SintomasSubmitCreateDTO request);

    SintomasResponseDTO selectSintoma(int id);

    List<SintomasResponseDTO> listAllSintomas();
}