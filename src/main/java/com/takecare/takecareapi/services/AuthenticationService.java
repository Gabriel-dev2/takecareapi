package com.takecare.takecareapi.services;

import com.takecare.takecareapi.api.dto.LoginResponseDTO;
import com.takecare.takecareapi.api.dto.SubmitLoginRequestDTO;

public interface AuthenticationService {

    LoginResponseDTO authenticate(SubmitLoginRequestDTO request);

    
}