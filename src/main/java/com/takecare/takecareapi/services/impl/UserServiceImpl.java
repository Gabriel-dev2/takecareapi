package com.takecare.takecareapi.services.impl;

import com.takecare.takecareapi.api.dto.SubmitCreateRequestDTO;
import com.takecare.takecareapi.api.dto.SubmitEditUserRequestDTO;
import com.takecare.takecareapi.api.dto.SubmitResponseDTO;
import com.takecare.takecareapi.api.dto.UserResponseDTO;
import com.takecare.takecareapi.entities.Login;
import com.takecare.takecareapi.entities.Paciente;
import com.takecare.takecareapi.entities.PlanoSaude;
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
        paciente.setIdPlano(request.getIdPlano());
        paciente.setEmail(request.getEmail());
        l.setCpf(request.getCpf());
        l.setSenha(request.getSenha());

        loginRepo.save(l);
        pacienteRepo.save(paciente);
        
        SubmitResponseDTO response = new SubmitResponseDTO();
        response.setMessage("Usuário criado com sucesso");
        return response;
    }

    @Override
    public UserResponseDTO findUserById(int id) {
        Paciente paciente = new Paciente();
        UserResponseDTO responseDTO = new UserResponseDTO();
        try {
            paciente = pacienteRepo.findById(id);
            responseDTO.setPaciente(paciente);  
        } catch (Exception e) {
            e.printStackTrace();
        }
        
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

    @Override
    public SubmitResponseDTO editUser(SubmitEditUserRequestDTO request) {
        SubmitResponseDTO responseDTO = new SubmitResponseDTO();

        try {
            Paciente p = pacienteRepo.findById(request.getId());
            if(!request.getName().equals(p.getName())) {
                 pacienteRepo.updateUserName(request.getName(), request.getId());
            } else if(!request.getEmail().equals(p.getEmail())) {
                pacienteRepo.updateUserEmail(request.getEmail(), request.getId());
            } else if(!request.getEndereco().equals(p.getEndereco())) {
                pacienteRepo.updateUserAddress(request.getEndereco(), request.getId());
            } else if(request.getNumeroCasa() != p.getNumeroCasa()) {
                pacienteRepo.updateUserAddressNumber(request.getNumeroCasa(), request.getId());
            } else if(request.getIdPlano() != p.getIdPlano()) {
                pacienteRepo.updateUserHelthPlan(request.getIdPlano(), request.getId());
            }
            responseDTO.setMessage("Usuário editado com sucesso");
        } catch (Exception e) {
            responseDTO.setMessage("Não foi possivel executar essa operação no momento");
            e.printStackTrace();
        }

        return responseDTO;
    }

    @Override
    public UserResponseDTO findUserByCPF(String cpf) {
        Paciente p = new Paciente();

        UserResponseDTO responseDTO = new UserResponseDTO();
        try {
            p = pacienteRepo.findByCpf(cpf);
            responseDTO.setPaciente(p);  
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseDTO;
    }

}