package com.takecare.takecareapi.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import com.takecare.takecareapi.api.dto.HistoricoResponseDTO;
import com.takecare.takecareapi.services.HistoricoService;

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
@RequestMapping(path = "api/history", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Service History", tags = "Users Service History", description = "Endpoint for service history")
public class ServiceHistoryController {

    private HistoricoService historico;
    
    @Autowired
    public ServiceHistoryController(HistoricoService historico) {
        this.historico = historico;
    }
    
    @GetMapping(path = "/getHistory/{idPaciente}")
    @ApiOperation(value = "Get patient history")
    @ApiResponses(value = {@ApiResponse( code = 200, message = "List all patient history"),
    @ApiResponse( code = 404, message = "This user does not have history information")})
    public ResponseEntity<HistoricoResponseDTO> getHistorico(@ApiParam("User Id") @Valid @PathVariable Integer idPaciente) {
        ResponseEntity<HistoricoResponseDTO> response = null;
        List<HistoricoResponseDTO> historicoResponse = this.historico.recuperarHistorico(idPaciente);
        for (HistoricoResponseDTO responseDto : historicoResponse) {
            if (responseDto.getMessage() != null && responseDto.getMessage() != "") {
                   response = new ResponseEntity<HistoricoResponseDTO>(responseDto, HttpStatus.NOT_FOUND);
                } else {
                    response = new ResponseEntity<HistoricoResponseDTO>(responseDto, HttpStatus.OK);
                }
        }
        
        return response;
    }
}
