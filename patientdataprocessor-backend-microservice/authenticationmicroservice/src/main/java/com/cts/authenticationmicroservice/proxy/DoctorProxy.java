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

@FeignClient(name = "doctor", url = "localhost:8084")
public interface DoctorProxy {

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("/api/v1.0/doctor/retrieveAllDoctorDetails")
	public ResponseEntity<List<Doctor>> retrieveAllDoctorDetails();
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("/api/v1.0/doctor/retrieveDoctorDetailsById/{emailId}")
	public ResponseEntity<Doctor> retrieveDoctorDetailsById(@PathVariable String emailId);
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/api/v1.0/doctor/doctorRegistration")
	public ResponseEntity<Doctor> doctorRegistration(@RequestBody Doctor doctor);
	
}
