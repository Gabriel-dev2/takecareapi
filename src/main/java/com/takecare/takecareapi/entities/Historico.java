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
@Table(name = "historco")

@Data
@AllArgsConstructor
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhistorico")
    private int idHistorico;

    @Column(name = "datahora")
    private Date dataHora;

    @Column(name = "placaAmbulancia")
    private String placaAmbulancia;

    @Column(name = "id_chamado")
    private int idChamado;

    @Column(name = "nomeSintoma")
    private String nomeSintoma;

    @Column(name = "nomeHospital")
    private String nomeHospital;

    @Column(name = "nomedoPlano")
    private String nomePlano;

    public Historico() {}
}