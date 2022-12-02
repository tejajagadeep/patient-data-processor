package com.cts.patientdataprocessor.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.patientdataprocessor.model.Patient;
import com.cts.patientdataprocessor.model.Report;
import com.cts.patientdataprocessor.servcie.PatientService;

@RestController
@RequestMapping("/api/v1.0/patient")
@CrossOrigin(origins="*")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
//	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("/getAllPatients")
	public ResponseEntity<List<Patient>> getAllPatients(){
		return new ResponseEntity<>(patientService.getAllPatients(),HttpStatus.OK);
	}
	
//	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("/getByContactNumber/{contactNumber}")
	public ResponseEntity<Patient> getByContactNumber(@PathVariable Long contactNumber) {
		return new ResponseEntity<>(patientService.getByContactNumber(contactNumber),HttpStatus.OK);
	}
	
//	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("/patientReports/{contactNumber}")
	public ResponseEntity<Set<Report>> getBypatientReports(@PathVariable Long contactNumber) {
		return new ResponseEntity<>(patientService.getBypatientReports(contactNumber),HttpStatus.OK);
	}
	
//	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@PostMapping("/registerPatient")
	public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient) {
		return new ResponseEntity<>(patientService.registerPatient(patient),HttpStatus.OK);
	}
	
//	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@PutMapping("/updatePatientDetails/{contactNumber}")
	public ResponseEntity<Patient> updatePatientDetails(@PathVariable Long contactNumber, @RequestBody Patient patient) {
		return new ResponseEntity<>(patientService.updatePatientDetails(contactNumber, patient),HttpStatus.OK);
	}
	
//	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@DeleteMapping("/deletePatient/{contactNumber}")
	public ResponseEntity<List<Patient>> deletePatient(@PathVariable Long contactNumber) {
		return new ResponseEntity<>(patientService.deletePatient(contactNumber),HttpStatus.OK);
	}
	
	
}