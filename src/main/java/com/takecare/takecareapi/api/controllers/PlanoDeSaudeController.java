package com.takecare.takecareapi.api.controllers;

import javax.validation.Valid;

import com.takecare.takecareapi.api.dto.BuscarPlanoDeSaudeResponseDTO;
import com.takecare.takecareapi.api.dto.InsertPlanoDeSaudeDTO;
import com.takecare.takecareapi.api.dto.PlanoDeSaudeResponseDTO;
import com.takecare.takecareapi.services.PlanoDeSaudeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Plano de Saude", tags = "Plano de Saude", description = "Endpoint for Health Plan related operations")
public class PlanoDeSaudeController {
    
    private PlanoDeSaudeService saudeService;

    @Autowired
    public PlanoDeSaudeController(PlanoDeSaudeService s){
        this.saudeService = s;
    }

    @PostMapping(path = "/plan/insert")
    @ApiOperation(value = "Insert's related health plan")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "The operation had a problem"),
        @ApiResponse(code = 500, message = "Erro")
    })
    public ResponseEntity<PlanoDeSaudeResponseDTO> insertPlano(@RequestBody InsertPlanoDeSaudeDTO body){
        ResponseEntity<PlanoDeSaudeResponseDTO> response = null;

        try {
            PlanoDeSaudeResponseDTO pResponseDTO = this.saudeService.insertPlanoDeSaude(body);
            if(pResponseDTO != null && pResponseDTO.getMessage().equals("Plano Cadastrado com sucesso")){
                response = new ResponseEntity<PlanoDeSaudeResponseDTO>(pResponseDTO, HttpStatus.OK);
            } else if(pResponseDTO.getMessage().equals("Não foi possível executar essa operação")){
                response = new ResponseEntity<PlanoDeSaudeResponseDTO>(pResponseDTO, HttpStatus.BAD_REQUEST);
            } else {
                pResponseDTO.setMessage("Houve um ero ao executar essa operação, tente mais tarde ou contate suporte");
                response = new ResponseEntity<PlanoDeSaudeResponseDTO>(pResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return response;
    }

    @GetMapping(path = "/plan/getPlan/{id}")
    @ApiOperation(value = "Get user by id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 404, message = "Plan not found")
    })
    public ResponseEntity<BuscarPlanoDeSaudeResponseDTO> searchPlan(@ApiParam("Plan id") @Valid @PathVariable Integer id){
        ResponseEntity<BuscarPlanoDeSaudeResponseDTO> response = null;

        try {
            BuscarPlanoDeSaudeResponseDTO buscaResponse = this.saudeService.findPlanoById(id);
            if(buscaResponse.getMessage().equals("OK")) {
                response = new ResponseEntity<BuscarPlanoDeSaudeResponseDTO>(buscaResponse, HttpStatus.OK);
            } else if(buscaResponse.getMessage().equals("Usuário não encontrado")) {
                response = new ResponseEntity<BuscarPlanoDeSaudeResponseDTO>(buscaResponse, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}