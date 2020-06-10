package com.takecare.takecareapi.services.impl;

import java.util.Optional;

import com.takecare.takecareapi.api.dto.CreateAtendenteDTO;
import com.takecare.takecareapi.api.dto.LoginAtendenteDTO;
import com.takecare.takecareapi.api.dto.LoginAtendenteResponseDTO;
import com.takecare.takecareapi.entities.LoginAtendente;
import com.takecare.takecareapi.repository.LoginAtendenteRepository;
import com.takecare.takecareapi.services.AuthenticationWorkerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationWorkerServiceImpl implements AuthenticationWorkerService {

    @Autowired
    LoginAtendenteRepository loginAtendenteRepo;

    @Override
    public LoginAtendenteResponseDTO authenticate(LoginAtendenteDTO request) {
        String matricula = request.getMatricula();
        String senha = request.getSenha();

        LoginAtendenteResponseDTO responseDTO = new LoginAtendenteResponseDTO();

        try {
            Optional<LoginAtendente> LoginAtendente = loginAtendenteRepo.findByMatricula(matricula);
            if(LoginAtendente.isPresent()) {
                if(LoginAtendente.equals(null)) {
                    responseDTO.setMessage("Login incorreto ou não existe");
                } else if(!senha.equals(LoginAtendente.get().getSenha())) {
                    responseDTO.setMessage("Senha incorreta");
                } else {
                    responseDTO.setMessage("Autenticação completa");
                }
            } else {
                responseDTO.setMessage("Login incorreto ou não existe");
            }
        }catch(Exception ex){
            responseDTO.setMessage("Erro: " + ex.getMessage());
        }

        return responseDTO;
    }

    @Override
    public LoginAtendenteResponseDTO createLogin(CreateAtendenteDTO request) {
        String matricula = request.getMatricula();
        String nome = request.getNome();
        String senha = request.getSenha();

        LoginAtendenteResponseDTO responseDTO = new LoginAtendenteResponseDTO();

        try {
            LoginAtendente atendente = new LoginAtendente();
            atendente.setMatricula(matricula);
            atendente.setNome(nome);
            atendente.setSenha(senha);

            loginAtendenteRepo.save(atendente);
            responseDTO.setMessage("Usuário criado com sucesso");
        } catch (Exception e) {
            responseDTO.setMessage("Houve um erro ao criar o usuário");
        }

        return responseDTO;
    }
    
}