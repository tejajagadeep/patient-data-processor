package com.cts.authenticationmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.authenticationmicroservice.model.Doctor;
import com.cts.authenticationmicroservice.proxy.DoctorProxy;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1.0/doctor")
public class DoctorController {

	@Autowired
	DoctorProxy doctorProxy;
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("/retrieveAllDoctorDetails")
	public ResponseEntity<List<Doctor>> retrieveAllDoctorDetails(){
		return this.doctorProxy.retrieveAllDoctorDetails();
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("/retrieveDoctorDetailsById/{emailId}")
	public ResponseEntity<Doctor> retrieveDoctorDetailsById(@PathVariable String emailId){
		return this.doctorProxy.retrieveDoctorDetailsById(emailId);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/doctorRegistration")
	public ResponseEntity<Doctor> doctorRegistration(@RequestBody Doctor doctor){
		return this.doctorProxy.doctorRegistration(doctor);
	}
}
