package com.takecare.takecareapi.api.controllers;

import com.takecare.takecareapi.api.dto.CreateAtendenteDTO;
import com.takecare.takecareapi.api.dto.LoginAtendenteDTO;
import com.takecare.takecareapi.api.dto.LoginAtendenteResponseDTO;
import com.takecare.takecareapi.services.AuthenticationWorkerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "api/worker", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Worker Auth", tags = "Worker Authenticator", description = "Endpoint for workers auth")
public class AuthWorkerController {
    
    private AuthenticationWorkerService workerService;

    @Autowired
    public AuthWorkerController(AuthenticationWorkerService service){  
        this.workerService = service;
    }

    @PostMapping(path = "/create")
    @ApiOperation(value = "Create Worker")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Worker created with success")})
    public ResponseEntity<LoginAtendenteResponseDTO> createWorker(@RequestBody CreateAtendenteDTO body) {
        ResponseEntity<LoginAtendenteResponseDTO> responseEntity = null;

        try {
            LoginAtendenteResponseDTO responseDTO = this.workerService.createLogin(body);
            if(responseDTO != null && responseDTO.getMessage().equals("Usuário criado com sucesso")){
                responseEntity = new ResponseEntity<LoginAtendenteResponseDTO>(responseDTO, HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<LoginAtendenteResponseDTO>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            LoginAtendenteResponseDTO responseDTO = new LoginAtendenteResponseDTO();
            responseDTO.setMessage("Erro: " + e.getMessage());
            responseEntity = new ResponseEntity<LoginAtendenteResponseDTO>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
            return responseEntity;
        }

        return responseEntity;
    }

    @PostMapping(value = "/login")
    @ApiOperation(value = "Authenticate Worker")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Authentication Completed"),
        @ApiResponse(code = 401, message = "Unauthorized")
    })
    public ResponseEntity<LoginAtendenteResponseDTO> authenticate(@RequestBody LoginAtendenteDTO body) {
        ResponseEntity<LoginAtendenteResponseDTO> responseEntity = null;

        try {
            LoginAtendenteResponseDTO responseDTO = this.workerService.authenticate(body);
            if(responseDTO != null && responseDTO.getMessage().equals("Autenticação completa")) {
                responseEntity = new ResponseEntity<LoginAtendenteResponseDTO>(responseDTO, HttpStatus.OK);
            } else if(responseDTO.getMessage().equals("Login incorreto ou não existe") || responseDTO.getMessage().equals("Senha incorreta")) {
                responseEntity = new ResponseEntity<LoginAtendenteResponseDTO>(responseDTO, HttpStatus.UNAUTHORIZED);
            } else {
                responseEntity = new ResponseEntity<LoginAtendenteResponseDTO>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            LoginAtendenteResponseDTO responseDTO = new LoginAtendenteResponseDTO();
            responseDTO.setMessage("Erro: " + e.getMessage());
            responseEntity = new ResponseEntity<LoginAtendenteResponseDTO>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
            return responseEntity;
        }

        return responseEntity;
    }
}