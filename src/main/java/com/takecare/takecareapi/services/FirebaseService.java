package com.takecare.takecareapi.services;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface FirebaseService {

    String addUserOnDb(String dbName, String nomePaciente, String cpfPaciente, String enderecoPaciente) throws InterruptedException, ExecutionException, IOException;
    
    String removeUserFromDb();

    String selectUserFromDb(String dbName, String userId) throws InterruptedException, ExecutionException, IOException;
}