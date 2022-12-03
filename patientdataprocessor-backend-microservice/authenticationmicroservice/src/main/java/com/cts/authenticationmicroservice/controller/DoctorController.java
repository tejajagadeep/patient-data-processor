package com.cts.authenticationmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.authenticationmicroservice.model.Doctor;
import com.cts.authenticationmicroservice.model.UserRole;
import com.cts.authenticationmicroservice.proxy.DoctorProxy;
import com.cts.authenticationmicroservice.repository.UserRoleRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1.0/doctor")
public class DoctorController {

	@Autowired
	DoctorProxy doctorProxy;
	
	@Autowired
	UserRoleRepository userRoleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Operation(summary = "Retrieve All Doctors' Details", description = "Retrieve all the doctors' details from the data base. Access by only ADMIN")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("")
	public ResponseEntity<List<Doctor>> retrieveAllDoctorDetails(){
		return this.doctorProxy.retrieveAllDoctorDetails();
	}
	
	@Operation(summary = "Retrieve Doctor Details", description = "Retrieve the doctors by giving email address from the data base")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("/emailId/{emailId}")
	public ResponseEntity<Doctor> retrieveDoctorDetailsById(@PathVariable String emailId){
		return this.doctorProxy.retrieveDoctorDetailsById(emailId);
	}
	
	@Operation(summary = "Doctor Registration", description = "Admin Register the doctor details into the data base. Access by only ADMIN")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/doctorRegistration")
	public ResponseEntity<Doctor> doctorRegistration(@RequestBody Doctor doctor){
		
		String encryptedPassword = passwordEncoder.encode(doctor.getPassword());
		doctor.setPassword(encryptedPassword);
		UserRole user = new UserRole();
		user.setUserName(doctor.getEmailId());
		user.setPassword(encryptedPassword);
		user.setRole("DOCTOR");
		userRoleRepository.save(user);
		
		return this.doctorProxy.doctorRegistration(doctor);
	}
}
