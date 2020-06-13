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
@Table(name = "ambulancia")

@Data
@AllArgsConstructor
public class Ambulancia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ambulancia")
    private int idAmbulancia;

    @Column(name = "nomemotorista")
    private String nomeMotorista;

    @Column(name = "id_feedback")
    private int idFeedBack;

    @Column(name = "quantidade")
    private int quantidate;

    @Column(name = "id_hospital")
    private int idHospital;
}