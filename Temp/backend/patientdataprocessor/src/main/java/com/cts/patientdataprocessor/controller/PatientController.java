package com.cts.patientdataprocessor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.patientdataprocessor.model.Patient;
import com.cts.patientdataprocessor.service.PatientService;

@RestController
@RequestMapping("/api/v1.0/patient")
public class PatientController {

	
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/getAllPatients")
	public List<Patient> getAllPatients(){
		return patientService.getAllPatients();
	}
	
	@GetMapping("/getByContactNumber/{contactNumber}")
	public Patient getByContactNumber(@PathVariable Long contactNumber) {
		return patientService.getByContactNumber(contactNumber);
	}
	
	
	@PostMapping("/registerPatient")
	public Patient registerPatient(@RequestBody Patient patient) {
		return patientService.registerPatient(patient);
	}
}
