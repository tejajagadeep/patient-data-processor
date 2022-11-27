package com.cts.patientdataprocessorbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.patientdataprocessorbackend.model.User;
import com.cts.patientdataprocessorbackend.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1.0/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		
		return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
	}
	
//	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("/getUserByEmailId/{emailId}")
	public ResponseEntity<User> getUserByUserName(@PathVariable String userName){
		
		return new ResponseEntity<>(userService.getUserByUserName(userName),HttpStatus.OK);
	}
}
