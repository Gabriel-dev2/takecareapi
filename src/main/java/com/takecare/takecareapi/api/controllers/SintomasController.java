package com.takecare.takecareapi.api.controllers;

import java.util.List;

import javax.validation.Valid;

import com.takecare.takecareapi.api.dto.SintomasResponseDTO;
import com.takecare.takecareapi.api.dto.SintomasSubmitCreateDTO;
import com.takecare.takecareapi.api.dto.SintomasSubmitResponseDTO;
import com.takecare.takecareapi.services.SintomasService;

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
@RequestMapping(path = "api/v1/", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Sintomas", tags = "Sintomas", description = "Endpoint to manage symptoms")
public class SintomasController {
    private SintomasService sintomas;

    @Autowired
    public SintomasController(SintomasService s) {
        this.sintomas = s;
    }

    @PostMapping(path = "sintomas/create")
    @ApiOperation(value = "Insert symptoms on database")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Symptom inserted with success"),
            @ApiResponse(code = 400, message = "The operation had a problem") })
    public ResponseEntity<SintomasSubmitResponseDTO> createSintoma(@RequestBody SintomasSubmitCreateDTO body) {
        ResponseEntity<SintomasSubmitResponseDTO> response = null;
        try {
            SintomasSubmitResponseDTO responseDTO = this.sintomas.insertSintoma(body);
            if (responseDTO != null && responseDTO.getMessage().equals("Sintoma inserido com sucesso")) {
                response = new ResponseEntity<SintomasSubmitResponseDTO>(responseDTO, HttpStatus.OK);
            } else if (responseDTO == null
                    || responseDTO.getMessage().equals("Ocorreu um problema ao inserir seu sintoma")) {
                response = new ResponseEntity<SintomasSubmitResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    @GetMapping(path = "sintomas/getUser/{id}")
    @ApiOperation(value = "Select Symptom")
    @ApiResponses(value = { @ApiResponse(code = 404, message = "Symptom not found"),
            @ApiResponse(code = 200, message = "User Found") })
    public ResponseEntity<SintomasResponseDTO> getSintoma(@ApiParam("Symptom Id") @Valid @PathVariable Integer id) {
        SintomasResponseDTO responseDTO = new SintomasResponseDTO();
        responseDTO = this.sintomas.selectSintoma(id);

        return ResponseEntity.ok().body(responseDTO);
    }

    @GetMapping(path = "sintomas/listAll")
    @ApiOperation(value = "List all symptoms")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Symptoms not found") })
    public ResponseEntity<List<SintomasResponseDTO>> getAllSintomas() {
        ResponseEntity<List<SintomasResponseDTO>> responseEntity = null;
        try {
            List<SintomasResponseDTO> response = this.sintomas.listAllSintomas();
            if(response.isEmpty()) {
                responseEntity = new ResponseEntity<List<SintomasResponseDTO>>(response, HttpStatus.NOT_FOUND);
            } else {
                responseEntity = new ResponseEntity<List<SintomasResponseDTO>>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }
}