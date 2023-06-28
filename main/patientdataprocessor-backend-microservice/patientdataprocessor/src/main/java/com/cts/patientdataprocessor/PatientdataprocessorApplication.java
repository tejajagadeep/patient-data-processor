package com.cts.patientdataprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PatientdataprocessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientdataprocessorApplication.class, args);
	}

}
