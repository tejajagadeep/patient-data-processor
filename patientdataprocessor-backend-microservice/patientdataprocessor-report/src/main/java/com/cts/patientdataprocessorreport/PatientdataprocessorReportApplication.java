package com.cts.patientdataprocessorreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PatientdataprocessorReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientdataprocessorReportApplication.class, args);
	}

}
