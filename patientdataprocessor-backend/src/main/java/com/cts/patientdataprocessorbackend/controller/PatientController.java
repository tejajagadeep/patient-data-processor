package com.cts.patientdataprocessorbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.patientdataprocessorbackend.model.Patient;
import com.cts.patientdataprocessorbackend.service.PatientService;


@RestController
@RequestMapping("/api/v1.0/patient")
@CrossOrigin(origins="*")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("/getAllPatients")
	public List<Patient> getAllPatients(){
		return patientService.getAllPatients();
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("/getByContactNumber/{contactNumber}")
	public Patient getByContactNumber(@PathVariable Long contactNumber) {
		return patientService.getByContactNumber(contactNumber);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@PostMapping("/registerPatient")
	public Patient registerPatient(@RequestBody Patient patient) {
		return patientService.registerPatient(patient);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("/updatePatientDetails/{contactNumber}")
	public Patient updatePatientDetails(@PathVariable Long contactNumber, @RequestBody Patient patient) {
		return patientService.updatePatientDetails(contactNumber, patient);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("/deletePatient/{contactNumber}")
	public List<Patient> deletePatient(@PathVariable Long contactNumber) {
		return patientService.deletePatient(contactNumber);
	}
}
