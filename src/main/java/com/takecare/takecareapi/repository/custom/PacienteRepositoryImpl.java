package com.takecare.takecareapi.repository.custom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class PacienteRepositoryImpl {
    @PersistenceContext
    EntityManager entityManager;
    

}