package com.cts.authenticationmicroservice.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.authenticationmicroservice.model.Doctor;

@FeignClient(name = "doctors", path = "/api/v1.0/doctor")
public interface DoctorProxy {

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("")
	public ResponseEntity<List<Doctor>> retrieveAllDoctorDetails();
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("/emailId/{emailId}")
	public ResponseEntity<Doctor> retrieveDoctorDetailsById(@PathVariable String emailId);
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/doctorRegistration")
	public ResponseEntity<Doctor> doctorRegistration(@RequestBody Doctor doctor);
	
}
