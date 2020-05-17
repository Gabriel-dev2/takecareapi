package com.takecare.takecareapi.services;

import com.takecare.takecareapi.api.dto.LoginResponseDTO;
import com.takecare.takecareapi.api.dto.SubmitLoginRequestDTO;
import com.takecare.takecareapi.entities.Login;

public interface AuthenticationService {

    LoginResponseDTO authenticate(SubmitLoginRequestDTO request);
    
}