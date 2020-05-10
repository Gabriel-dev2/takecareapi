package com.takecare.takecareapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "paciente")

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

    @ManyToOne
    @JoinColumn(name="id_planodesaude")
    private PlanoSaude plano;

    @Column(name = "numerocasa")
    private int numeroCasa;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "pais")
    private String pais;

    @Column(name = "cep")
    private String cep;

    public Paciente(){}
    
}