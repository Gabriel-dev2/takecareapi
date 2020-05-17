package com.takecare.takecareapi.services.impl;


import com.takecare.takecareapi.api.dto.LoginResponseDTO;
import com.takecare.takecareapi.api.dto.SubmitLoginRequestDTO;
import com.takecare.takecareapi.entities.Login;
import com.takecare.takecareapi.repository.LoginRepository;
import com.takecare.takecareapi.services.AuthenticationService;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    LoginRepository loginRepo;

    @Override
    public LoginResponseDTO authenticate(SubmitLoginRequestDTO request) {
        Login l = new Login();
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        l = loginRepo.getOne(request.getCpf());
        if(l.equals(null)) {
            loginResponseDTO.setMessage("Login incorreto ou não existe");
        } else if(l.getSenha() != request.getSenha()) {
            loginResponseDTO.setMessage("Senha incorreta");
        } else {
            loginResponseDTO.setLogin(l);
            loginResponseDTO.setMessage("OK");
        }

        return loginResponseDTO;
    }
    
}