package com.takecare.takecareapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "hospital")

@Data
@AllArgsConstructor
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hospital")
    private int idHospital;

    @Column(name = "nomehospital")
    private String nomeHospital;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "id_planodesaude")
    private int idPlanoDeSaude;

    public Hospital(){}
}