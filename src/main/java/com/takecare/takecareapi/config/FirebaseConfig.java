package com.takecare.takecareapi.config;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import org.springframework.context.annotation.Configuration;

@Configuration
public class FirebaseConfig {
    
    public Firestore getFirebaseClient() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("/home/glcl/workspace/takecareapi/src/main/resources/takecare-618e7-firebase-adminsdk-y4dez-d407b852ff.json");
       
        FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://takecare-618e7.firebaseio.com")
            .setProjectId("takecare-618e7")
            .build();

// FirebaseApp.initializeApp(options);

        // GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
        // FirebaseOptions options = new FirebaseOptions.Builder()
        //     .setCredentials(credentials)
        //     .setProjectId("takecare-618e7")
        //     .build();
        FirebaseApp.initializeApp(options);
        Firestore db = FirestoreClient.getFirestore();
        return db;
    }

    
}