package com.takecare.takecareapi.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import com.takecare.takecareapi.api.dto.EmergenciaResponseDTO;
import com.takecare.takecareapi.services.ChamadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "api/call", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Call Ambulance", tags = "Call Ambulance", description = "Endpoint for Call Ambulance")
public class CallEmergencyController {

    private ChamadoService chamado;

    @Autowired
    public CallEmergencyController(ChamadoService chamado) {
        this.chamado = chamado;
    }

    @GetMapping(path = "/emergency/{idPaciente}")
    @ApiOperation(value = "Calls emergency")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Calls emergency"),
            @ApiResponse(code = 404, message = "Could not find emergency service") })
    public ResponseEntity<EmergenciaResponseDTO> callEmergency(@ApiParam("User Id") @Valid @PathVariable Integer idPaciente) {
        ResponseEntity<EmergenciaResponseDTO> response = null;

        EmergenciaResponseDTO responseDTO = this.chamado.chamarEmergencia(idPaciente);

        response = new ResponseEntity<EmergenciaResponseDTO>(responseDTO, HttpStatus.OK);
        
        return response;
    }
}
