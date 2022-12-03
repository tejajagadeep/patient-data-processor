package com.cts.authenticationmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.authenticationmicroservice.model.Results;
import com.cts.authenticationmicroservice.proxy.ResultsProxy;

@RestController
@RequestMapping("/api/v1.0/results")
@CrossOrigin(origins="*")
public class ResultsController {

	@Autowired
	ResultsProxy resultsproxy;
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("/contactNumber/{contactNumber}")
	public ResponseEntity<List<Results>> getByContactNumber(@PathVariable Long contactNumber) {
		return this.resultsproxy.getByContactNumber(contactNumber);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@PostMapping("/saveResults")
	public ResponseEntity<Results> saveResults(@RequestBody Results results) {
		return this.resultsproxy.saveResults(results);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@DeleteMapping("/id/{id}")
	public ResponseEntity<List<Results>> delete(@PathVariable int id) {
		return this.resultsproxy.delete(id);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@DeleteMapping("/contactNumber/{contactNumber}")
	public ResponseEntity<List<Results>> deleteAllByContactNumber(@PathVariable Long contactNumber) {
		return this.resultsproxy.deleteAllByContactNumber(contactNumber);
	}
}
