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

import com.cts.authenticationmicroservice.model.Report;
import com.cts.authenticationmicroservice.proxy.ReportProxy;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/v1.0/report")
@CrossOrigin(origins="*")
public class ReportController {
	
	@Autowired
	private ReportProxy reportProxy;
	
//	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
//	@GetMapping("/getAllReports")
//	public ResponseEntity<List<Report>> getAllReports(){
//		return this.reportProxy.getAllReports();
//	}
	
	@Operation(summary = "Retrieve Patient's Report", description = "Retrieve blood pressure and sugar level of a Patient's Report details from the data base for analysis.")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("/contactNumber/{contactNumber}")
	public ResponseEntity<List<Report>> getAllByContactNumber(@PathVariable Long contactNumber){
		return this.reportProxy.getAllByContactNumber(contactNumber);
	}
	
	@Operation(summary = "Save Patient's Report Details", description = "Save blood pressure and sugar level of a Patient's Report details into the data base to analyse later.")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@PostMapping("/saveReport")
	public ResponseEntity<Report> saveReport(@RequestBody Report report){
		
		return this.reportProxy.saveReport(report);
	}
	
	@Operation(summary = "Delete Patient's Report Details", description = "Delete the Patient's Report details from the data base by Id.")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@DeleteMapping("/id/{id}")
	public ResponseEntity<List<Report>> delete(@PathVariable int id){
		return this.reportProxy.delete(id);
	}
	
	@Operation(summary = "Delete Patient's Report Details", description = "Delete All the Report details of a Patient from the data base by Contact Number.")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@DeleteMapping("/contactNumber/{contactNumber}")
	public ResponseEntity<List<Report>> deleteAllByContactNumber(@PathVariable Long contactNumber){
		return this.reportProxy.deleteAllByContactNumber(contactNumber);
	}

}
