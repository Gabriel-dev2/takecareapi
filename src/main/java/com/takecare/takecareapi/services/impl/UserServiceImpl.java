package com.takecare.takecareapi.services.impl;

import com.takecare.takecareapi.api.dto.SubmitCreateRequestDTO;
import com.takecare.takecareapi.api.dto.SubmitResponseDTO;
import com.takecare.takecareapi.api.dto.UserResponseDTO;
import com.takecare.takecareapi.entities.Login;
import com.takecare.takecareapi.entities.Paciente;
import com.takecare.takecareapi.repository.LoginRepository;
import com.takecare.takecareapi.repository.PacienteRepository;
import com.takecare.takecareapi.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    PacienteRepository pacienteRepo;
    LoginRepository loginRepo;

    @Autowired
    public UserServiceImpl(PacienteRepository p, LoginRepository login) {
        this.pacienteRepo = p;
        this.loginRepo = login;
    }

    @Override
    public SubmitResponseDTO createUser(SubmitCreateRequestDTO request) {
        Paciente paciente = new Paciente();
        Login l = new Login();

        paciente.setName(request.getName());
        paciente.setCpf(request.getCpf());
        paciente.setEndereco(request.getEndereco());
        paciente.setNumeroCasa(request.getNumeroCasa());

        l.setCpf(request.getCpf());
        l.setSenha(request.getSenha());

        pacienteRepo.save(paciente);
        loginRepo.save(l);
        
        SubmitResponseDTO response = new SubmitResponseDTO();
        response.setMessage("Usuário criado com sucesso");
        return response;
    }

    @Override
    public UserResponseDTO findUserById(int id) {
        Paciente paciente = new Paciente();
        UserResponseDTO responseDTO = new UserResponseDTO();
        paciente = pacienteRepo.findById(id);
        responseDTO.setPaciente(paciente);
        return responseDTO;
    }

    @Override
    public Paciente findUserByName(String userName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Paciente listAll() {
        return null;
    }

}