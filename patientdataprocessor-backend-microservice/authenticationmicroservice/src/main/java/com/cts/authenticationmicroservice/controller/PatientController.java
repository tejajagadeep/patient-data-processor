package com.cts.authenticationmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.authenticationmicroservice.model.Patient;
import com.cts.authenticationmicroservice.proxy.Proxy;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1.0/patient")
public class PatientController {

	@Autowired
	Proxy proxy;
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("/getAllPatients")
	public List<Patient> getAllPatients() {
	   return this.proxy.getAllPatients();
	}
}
