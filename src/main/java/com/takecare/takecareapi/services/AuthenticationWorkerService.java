package com.takecare.takecareapi.services;

import com.takecare.takecareapi.api.dto.CreateAtendenteDTO;
import com.takecare.takecareapi.api.dto.LoginAtendenteDTO;
import com.takecare.takecareapi.api.dto.LoginAtendenteResponseDTO;

public interface AuthenticationWorkerService {
    
    LoginAtendenteResponseDTO authenticate(LoginAtendenteDTO request);

    LoginAtendenteResponseDTO createLogin(CreateAtendenteDTO request);
}