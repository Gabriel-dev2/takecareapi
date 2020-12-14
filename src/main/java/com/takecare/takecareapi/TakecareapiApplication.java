package com.takecare.takecareapi;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TakecareapiApplication {

	@PostConstruct
	public void init() { TimeZone.setDefault(TimeZone.getTimeZone("America/Recife")); } 

	public static void main(String[] args) {
		SpringApplication.run(TakecareapiApplication.class, args);
	}

}
