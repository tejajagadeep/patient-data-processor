package com.cts.authenticationmicroservice.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.authenticationmicroservice.model.Patient;
import com.cts.authenticationmicroservice.model.Report;
import com.cts.authenticationmicroservice.proxy.PatientProxy;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1.0/patient")
public class PatientController {

	@Autowired
	PatientProxy proxy;
	
	@Operation(summary = "Retrieve All Patients' Details", description = "Retrieve all the Patients' details from the data base.")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("")
	public List<Patient> getAllPatients() {
	   return this.proxy.getAllPatients();
	}
	
	@Operation(summary = "Retrieve Patient's Details", description = "Retrieve the Patient's details from the data base by Contact Number.")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("/contactNumber/{contactNumber}")
	public Patient getByContactNumber(@PathVariable Long contactNumber) {
		return this.proxy.getByContactNumber(contactNumber);
	}
	
//	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
//	@GetMapping("/patientReports/{contactNumber}")
//	public Set<Report> getBypatientReports(@PathVariable Long contactNumber) {
//		return this.proxy.getBypatientReports(contactNumber);
//	}
	
	@Operation(summary = "Patient Registration", description = "Doctor will register the Patient's details into the data base so he can retrieve at later point.")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@PostMapping("/registerPatient")
	public Patient registerPatient(@RequestBody Patient patient) {
		return this.proxy.registerPatient(patient);
	}
	
	@Operation(summary = "Save Patient's Medical Record Details", description = "Doctor will save the Patient's Medical Record details into the data base so he can retrieve at later point.")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@PutMapping("/contactNumber/{contactNumber}")
	public Patient updatePatientDetails(@PathVariable Long contactNumber, @RequestBody Patient patient) {
		return this.proxy.updatePatientDetails(contactNumber, patient);
	}
	
	@Operation(summary = "Delete Patient's Details", description = "Delete the Patient's details from the data base by Contact Number.")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@DeleteMapping("/contactNumber/{contactNumber}")
	public List<Patient> deletePatient(@PathVariable Long contactNumber) {
		return this.proxy.deletePatient(contactNumber);
	}
	
}
