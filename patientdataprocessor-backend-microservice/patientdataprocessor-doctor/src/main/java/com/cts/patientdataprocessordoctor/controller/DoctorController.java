package com.cts.patientdataprocessordoctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.patientdataprocessordoctor.model.Doctor;
import com.cts.patientdataprocessordoctor.service.DoctorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1.0/doctor")
public class DoctorController {

	@Autowired
	DoctorService doctorService;
	
	@GetMapping("/retrieveAllDoctorDetails")
	public ResponseEntity<List<Doctor>> retrieveAllDoctorDetails(){
		
		return new ResponseEntity<>(doctorService.retrieveAllDoctorDetails(),HttpStatus.OK);
	}
	
	@GetMapping("/retrieveDoctorDetailsById/{emailId}")
	public ResponseEntity<Doctor> retrieveDoctorDetailsById(@PathVariable String emailId){
		return  new ResponseEntity<>(doctorService.retrieveDoctorDetailsById(emailId),HttpStatus.OK);
	}
	
	@PostMapping("/doctorRegistration")
	public ResponseEntity<Doctor> doctorRegistration(@RequestBody Doctor doctor){
		return  new ResponseEntity<>(doctorService.doctorRegistration(doctor),HttpStatus.CREATED);
	}
}
