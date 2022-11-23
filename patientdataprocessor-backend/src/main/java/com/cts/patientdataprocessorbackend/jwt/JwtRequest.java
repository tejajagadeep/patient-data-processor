package com.cts.patientdataprocessorbackend.jwt;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.patientdataprocessorbackend.PatientdataprocessorBackendApplication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String username;
	private String password;
	
	Logger log = LoggerFactory.getLogger(PatientdataprocessorBackendApplication.class);
	
	//need default constructor for JSON Parsing
	public JwtRequest()
	{
		
	}
	
	
}
