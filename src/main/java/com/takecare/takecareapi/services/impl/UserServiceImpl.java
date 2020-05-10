package com.takecare.takecareapi.services.impl;

import com.takecare.takecareapi.api.dto.UserResponseDTO;
import com.takecare.takecareapi.entities.Paciente;
import com.takecare.takecareapi.repository.PacienteRepository;
import com.takecare.takecareapi.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    PacienteRepository pacienteRepo;

    @Autowired
    public UserServiceImpl(PacienteRepository p) {
        this.pacienteRepo = p;
    }

    @Override
    public String createUser(String userName, String cpf, String endereco, int numeroCasa) {
        // TODO Auto-generated method stub
        return null;
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