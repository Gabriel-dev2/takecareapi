package com.takecare.takecareapi.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.takecare.takecareapi.entities.Historico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface HistoricoRepository extends JpaRepository<Historico, Integer> {
    List<Historico> findAll();

    @Query(value = "SELECT * FROM historico where historico.id_paciente =?1", nativeQuery = true)
    List<Historico> findByIdPaciente(Integer idPaciente);

    @Query(value = "SELECT idhistorico, datahoraa, placaAmbulancia, id_chamado, nomeSintoma, nomedoPlano, idlogatendente, id_paciente FROM historico WHERE id_paciente =?1", nativeQuery = true)
    List<Historico> findAllHistorico(Integer idPaciente);

    @Query(value = "select * from historico where datahoraa =?1", nativeQuery = true)
    Optional<Historico> findByData(LocalDateTime datahora);

    // @Modifying
    // @Transactional(readOnly = false)
    // @Query(value = "INSERT INTO historico (datahoraa, placaAmbulancia, id_chamado, nomeSintoma, nomeHospital, nomedoPlano, idlogatendente, id_paciente) VALUES(?, ?, ?, ?, ?, ?, ?, ?)", nativeQuery = true)
    // int insertValues(LocalDateTime datahora, String placaAmbulancia, int idChamado, String nomeSintoma, String nomeHospital, String nomeDoPlano, int idLogatendente, int idPaciente);

    @Modifying
    @Transactional(readOnly = false)
    @Query(value = "INSERT INTO historico (datahoraa, placa_ambulancia, nome_sintoma, nome_hospital, nomedo_plano, idlogatendente, id_paciente, id_chamado) VALUES(?, ?, ?, ?, ?, ?, ?, ?)", nativeQuery = true)
    int insertValues(LocalDateTime datahora, String placaAmbulancia, String nomeSintoma, String nomeHospital, String nomeDoPlano, int idLogatendente, int idPaciente, int id_chamado);

    @Modifying
    @Transactional(readOnly = false)
    @Query(value = "UPDATE historico SET historico.id_chamado =?1 WHERE historico.datahoraa=?2", nativeQuery = true)
    int updateHistorico(int idChamado, LocalDateTime datahora);

}
