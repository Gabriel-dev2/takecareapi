package com.takecare.takecareapi.services.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.takecare.takecareapi.config.FirebaseConfig;
import com.takecare.takecareapi.services.FirebaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirebaseServiceImpl implements FirebaseService {

    private Firestore db;
    private FirebaseConfig firebaseConfig;

    @Autowired
    public FirebaseServiceImpl(FirebaseConfig firebaseConfig) throws IOException {
        this.firebaseConfig = firebaseConfig;
        db = this.firebaseConfig.getFirebaseClient();
    }

    @Override
    public String addUserOnDb(String dbName, String nomePaciente, String cpfPaciente, String enderecoPaciente)
            throws InterruptedException, ExecutionException, IOException {
        DocumentReference doc = db.collection(dbName).document("1");

        Map<String, Object> data = new HashMap<>();
        data.put("nome", nomePaciente);
        data.put("cpf", cpfPaciente);
        data.put("endereco", enderecoPaciente);

        ApiFuture<WriteResult> result = doc.set(data);
        return result.get().getUpdateTime().toString();
    }

    @Override
    public String removeUserFromDb() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String selectUserFromDb(String dbName, String userId)
            throws InterruptedException, ExecutionException, IOException {
        String teste = "";
        CollectionReference ref = db.collection(dbName);
        Query query = ref.whereEqualTo("id", userId);
        
          
        return teste;
    }

}