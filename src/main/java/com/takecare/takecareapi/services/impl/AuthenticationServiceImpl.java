package com.takecare.takecareapi.services.impl;


import java.util.Optional;

import com.takecare.takecareapi.api.dto.LoginResponseDTO;
import com.takecare.takecareapi.api.dto.SubmitLoginRequestDTO;
import com.takecare.takecareapi.entities.Login;
import com.takecare.takecareapi.repository.LoginRepository;
import com.takecare.takecareapi.repository.PacienteRepository;
import com.takecare.takecareapi.services.AuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    LoginRepository loginRepo;

    @Override
    public LoginResponseDTO authenticate(SubmitLoginRequestDTO request) {
        String cpf = request.getCpf();
        String senha = request.getSenha();
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        try {
            Optional<Login> l = loginRepo.findByCpf(cpf);
            if(l.isPresent()){
                if(l.equals(null)) {
                    loginResponseDTO.setMessage("Login incorreto ou não existe");
                } else if(!senha.equals(l.get().getSenha())) {
                    loginResponseDTO.setMessage("Senha incorreta");
                } else {
                    loginResponseDTO.setCpf(l.get().getCpf());
                    loginResponseDTO.setMessage("OK");
                }
        }
        } catch(Exception e) {}

        return loginResponseDTO;
    }
    
}