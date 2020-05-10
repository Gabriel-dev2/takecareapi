package com.takecare.takecareapi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "Paciente")

@Data
@AllArgsConstructor
public class Paciente {

    @Id
    @Column(name = "id_Paciente")
    private int id;

    @Column(name = "nome")
    private String name;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "cep")
    private String cep;

    public Paciente(){}
    
}