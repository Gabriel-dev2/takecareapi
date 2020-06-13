package com.takecare.takecareapi.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "chamado")

@Data
@AllArgsConstructor
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chamado")
    private int id_chamado;

    @Column(name = "doencas")
    private String doencas;

    @Column(name = "dataehora")
    private Date dataHora;

    @Column(name = "status")
    private String status;

    @Column(name = "id_ambulancia")
    private int idAmbulancia;

    @Column(name = "id_paciente")
    private int idPaciente;

    @Column(name = "id_hospital")
    private int idHospital;

    public Chamado() {
        
    }

}