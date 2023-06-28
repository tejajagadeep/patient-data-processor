package com.cts.authenticationservice.controller;

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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/v1.0/results")
@CrossOrigin(origins="*")
public class ResultsController {

	@Autowired
	ResultsProxy resultsproxy;
	
	@Operation(summary = "Retrieve Patient's Results", description = "Retrieve Blood Test results of a Patient from the data base for analysis.")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@GetMapping("/contactNumber/{contactNumber}")
	public ResponseEntity<List<Results>> getByContactNumber(@PathVariable Long contactNumber) {
		return this.resultsproxy.getByContactNumber(contactNumber);
	}
	
	@Operation(summary = "Save Patient's Result Details", description = "Save Blood Test Result Details of a Patient into the data base to analyse later.")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@PostMapping("/saveResults")
	public ResponseEntity<Results> saveResults(@RequestBody Results results) {
		return this.resultsproxy.saveResults(results);
	}
	
	@Operation(summary = "Delete Patient's Result Details", description = "Delete the Patient's Blood Test Result details from the data base by Id.")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@DeleteMapping("/id/{id}")
	public ResponseEntity<List<Results>> delete(@PathVariable int id) {
		return this.resultsproxy.delete(id);
	}
	
	@Operation(summary = "Delete Patient's Results", description = "Delete All the Blood Test Results details of a Patient from the data base by Contact Number.")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@DeleteMapping("/contactNumber/{contactNumber}")
	public ResponseEntity<List<Results>> deleteAllByContactNumber(@PathVariable Long contactNumber) {
		return this.resultsproxy.deleteAllByContactNumber(contactNumber);
	}
}
