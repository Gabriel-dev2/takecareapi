package com.takecare.takecareapi.api.controllers;

import com.takecare.takecareapi.api.dto.LoginResponseDTO;
import com.takecare.takecareapi.api.dto.SubmitLoginRequestDTO;
import com.takecare.takecareapi.services.AuthenticationService;

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
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping(path = "api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Auth", tags = "Authenticator", description = "Endpoint for authentication")
public class AuthController {

    private AuthenticationService auth;

    @Autowired
    public AuthController(AuthenticationService auth){
        this.auth = auth;
    }
    
    @PostMapping(path = "/paciente/login")
    @ApiOperation(value = "Authenticate User")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 401, message = "Unauthorized")
    })
    public ResponseEntity<LoginResponseDTO> authenticate(@RequestBody SubmitLoginRequestDTO body){
        ResponseEntity<LoginResponseDTO> responseEntity = null;
        
        try{
            LoginResponseDTO response = auth.authenticate(body);
            if(response != null && response.getMessage().equals("OK")){
                responseEntity = new ResponseEntity<LoginResponseDTO>(response, HttpStatus.OK);
            } else if(response.getMessage().equals("Login incorreto ou não existe") || response.getMessage().equals("Senha incorreta")){
                responseEntity = new ResponseEntity<LoginResponseDTO>(response, HttpStatus.UNAUTHORIZED);
            }
        } catch(Exception e) {
            LoginResponseDTO responseDTO = new LoginResponseDTO();
            responseDTO.setMessage(e.getMessage());
            responseEntity = new ResponseEntity<LoginResponseDTO>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
            return responseEntity;
        }
        
        return responseEntity;
    }
}