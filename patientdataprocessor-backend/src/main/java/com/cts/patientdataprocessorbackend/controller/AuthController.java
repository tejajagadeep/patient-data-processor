package com.cts.patientdataprocessorbackend.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.patientdataprocessorbackend.PatientdataprocessorBackendApplication;
import com.cts.patientdataprocessorbackend.model.MessageResponse;
import com.cts.patientdataprocessorbackend.model.User;


@CrossOrigin(origins = "*")
@RestController
public class AuthController {

	@Autowired
	private AuthenticationManager auth;
	
	Logger log = LoggerFactory.getLogger(PatientdataprocessorBackendApplication.class);
	
	@PostMapping("/login")
	public ResponseEntity<String>  authenticateUser(@RequestBody User user) {
		
		Authentication authentication = auth.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseEntity<>("success",HttpStatus.OK);
	}
	
	@GetMapping("/basicauth")
	public ResponseEntity<MessageResponse>  authenticateUser1() {
		log.info("basicauth");
//		try {
		return new ResponseEntity<>(new MessageResponse(new Date(),"ADMIN",HttpStatus.OK),HttpStatus.OK);
//		return new ResponseEntity<>("String",HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(new MessageResponse(new Date(),"Invalid Credentials",HttpStatus.UNAUTHORIZED),HttpStatus.UNAUTHORIZED);
//		}
	}
	
}